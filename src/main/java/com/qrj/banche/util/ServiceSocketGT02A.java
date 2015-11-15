package com.qrj.banche.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class ServiceSocketGT02A extends Thread {

    private static int a = 1;
    public Socket sock;
    long shebeiid = 1234;
    Object o;


    public ServiceSocketGT02A(Socket sock,Object o) {
        this.sock = sock;
        this.o = o;
    }

    public void run() {
        try {
            while (a == 1) {
                if (!sock.isClosed()) {
                    InputStream is = sock.getInputStream();
                    byte[] buf = new byte[1024];
                    int len = is.read(buf);
                    if (len == -1) {
                        sock.close();
                        break;
                    }
//                    for (int i = 0; i < len; i++) {
//                        String aa = Integer.toHexString(buf[i] & 0x000000FF);
//                        if (aa.length() == 1) {
//                            aa = "0" + aa;
//                        }
//                        System.out.print(aa + "  ");
//                    }
                    OutputStream os = sock.getOutputStream();
                    if (len > 0) {
                        switch (buf[15]) {
                            case 16:
                                //gps
                                gpslbs(buf);
//                                System.out.println("GPS存储成功" + shebeiid);
                                break;
                            case 26:
                                //状态包
                                byte zhuangtaireturn[] = new byte[]{0x54,0x68,0x1A,0x0D,0x0A};
                                os.write(zhuangtaireturn);
//                                System.out.println("状态包返回成功" + shebeiid);
                                break;
                            default:
                                for (int i = 0; i < len; i++) {
                                    String aa = Integer.toHexString(buf[i] & 0x000000FF);
                                    if (aa.length() == 1) {
                                        aa = "0" + aa;
                                    }
                                    System.out.print(aa + "  ");
                                }
                                System.out.println();
                                break;
                        }
                    }
                }
            }
//            os.close();
//            is.close();
//            sock.close();
        } catch (SocketTimeoutException e) {
            try {
                sock.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void gpslbs(byte buf[]) throws UnsupportedEncodingException, ParseException {
        String ss = "";
        for (int i = 5; i < 13; i++) {
            String aa = Integer.toHexString(buf[i] & 0x000000FF);
            if (aa.length() == 1) {
                aa = "0" + aa;
            }
            ss = ss + aa;
        }
        shebeiid = Long.parseLong(ss);
        String jd = "";
        String wd = "";
        for (int i = 22; i < 26; i++) {
            String linjd = "";
            String linwd = "";
            linjd = Integer.toHexString(buf[i + 4] & 0x000000FF);
            linwd = Integer.toHexString(buf[i] & 0x000000FF);
            if (linjd.length() == 1) {
                linjd = "0" + linjd;
            }
            if (linwd.length() == 1) {
                linwd = "0" + linwd;
            }
            jd = jd + linjd;
            wd = wd + linwd;

        }

        double jingdu = formategps(Integer.valueOf(jd, 16));
        double weidu = formategps(Integer.valueOf(wd, 16));

        try {
            String baidugps = changtobaidu(jingdu, weidu);
            String gps[] = baidugps.split(",");
            jingdu = Double.parseDouble(gps[0]);
            weidu = Double.parseDouble(gps[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int sudu = Integer.valueOf(Integer.toHexString(buf[30] & 0x000000FF), 16);
        String shijian = "20";
        for (int i = 16; i < 22; i++) {
            String sss = String.valueOf(buf[i]);
            if (sss.length() == 1) {
                sss = "0" + sss;
            }
            shijian = shijian + sss + ":";
        }
        shijian = shijian.substring(0, shijian.length() - 1);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载mysq驱动
//            String url = "jdbc:mysql://120.24.92.204:3306/banche?useUnicode=true&amp;characterEncoding=UTF-8";
            String url = "jdbc:mysql://127.0.0.1:3306/banche?useUnicode=true&amp;characterEncoding=UTF-8";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from shebei WHERE shebei_id='" + shebeiid + "'";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                sql = "UPDATE shebei SET shebei_jingdu='" + jingdu + "',shebei_weidu='" + weidu + "',shebei_sudu='" + sudu + "',shebei_shijian='" + shijian + "' WHERE shebei_id='" + shebeiid + "'";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.executeUpdate();
            } else {

                sql = "INSERT INTO shebei VALUES (?,?,?,?,?)";
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setLong(1, shebeiid);
                pstmt.setDouble(2, jingdu);
                pstmt.setDouble(3, weidu);
                pstmt.setInt(4, sudu);
                pstmt.setString(5, shijian);
                pstmt.executeUpdate();
            }
            sql = "INSERT INTO shebeilishi(shebeilishi_shebeiid, shebeilishi_shebeijingdu, shebeilishi_shebeiweidu, shebeilishi_shebeisudu, shebeilishi_shebeishijian) VALUES (?,?,?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setLong(1, shebeiid);
            pstmt.setDouble(2, jingdu);
            pstmt.setDouble(3, weidu);
            pstmt.setInt(4, sudu);
            pstmt.setString(5, shijian);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();//打印出错详细信息
        }
        //关闭数据库
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            System.out.println("数据库关闭错误");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Object o = new Object();
            System.out.println("wo qi dong l ");
            ServerSocket ss = new ServerSocket(7741);
            while (a == 1) {
                Socket s = ss.accept();
                new ServiceSocketGT02A(s,o).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String changtobaidu(double x, double y) throws Exception {
        String qurl = "http://api.map.baidu.com/geoconv/v1/?"
                + "coords=" + x + "," + y
                + "&from=1&to=5"
                + "&ak=RMhB2Fq8pYX0K2R2H84bGyEW"
                + "&output=xml";
        SAXReader reader = new SAXReader();
        Document document = reader.read(new URL(qurl));
        Element rootElement = document.getRootElement();
        Element resultElement = rootElement.element("result").element("point");
        Element xElement = resultElement.element("x");
        Element yElement = resultElement.element("y");
        return xElement.getTextTrim() + "," + yElement.getTextTrim();
    }
    private double formategps(int zuobiao) {
        double a = Double.parseDouble(String.valueOf(zuobiao)) / 30000.00;
        double b = a % 60;
        int c = (int) Math.floor(a / 60);

        return c + (b / 60);
    }
}
