package com.qrj.banche.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class ServiceSocket6780 extends Thread {

    private static int a = 1;
    public Socket sock;
    long shebeiid = 1234;
    Object o;


    public ServiceSocket6780(Socket sock,Object o) {
        this.sock = sock;
        this.o = o;
    }

    public void run() {
        try {
            o.wait();
            while (a == 1) {
                if (!sock.isClosed()) {
                    InputStream is = sock.getInputStream();
                    byte[] buf = new byte[1024];
                    int len = is.read(buf);
                    if (len == -1) {
                        sock.close();
                        break;
                    }
                    OutputStream os = sock.getOutputStream();
                    if (len > 0) {
                        System.out.println(new String(buf, "utf-8"));
                        String s[] = new String(buf, "utf-8").split(",");
                        if (s[2].equals("V1")) {
                            gpslbs(s);
                            System.out.println("GPS包处理成功" + shebeiid);
                        } else {
                            System.out.println("这是其他数据信息");
                        }
                    }
                }
            }
//            os.close();
//            is.close();
//            sock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gpslbs(String s[]) throws UnsupportedEncodingException, ParseException {
        shebeiid = Long.parseLong(s[1]);
        DateFormat formatter = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");

        SimpleDateFormat sdtf = new SimpleDateFormat("HHmmssddMMyy");//小写的mm表示的是分钟
        String dstr = s[3] + s[11];
        String shijian = formatter.format(new Date());
        if (!dstr.equals("")) {
            Date date = sdtf.parse(dstr);

            TimeZone srcTimeZone = TimeZone.getTimeZone("GMT");
            TimeZone destTimeZone = TimeZone.getTimeZone("GMT+8");
            Long targetTime = date.getTime() - srcTimeZone.getRawOffset() + destTimeZone.getRawOffset();
            shijian = formatter.format(new Date(targetTime));
        }
        double weidu = Double.parseDouble(s[5].substring(0, 2))
                + (Double.parseDouble(s[5].substring(2, s[5].length())) / 60.0);
        double jingdu = Double.parseDouble(s[7].substring(0, 3))
                + (Double.parseDouble(s[7].substring(3, s[5].length())) / 60.0);
        int sudu = Integer.parseInt(new java.text.DecimalFormat("0").format(Double.parseDouble(s[9]) * 1.85));

        try {
            String baidugps = changtobaidu(jingdu, weidu);
            String gps[] = baidugps.split(",");
            jingdu = Double.parseDouble(gps[0]);
            weidu = Double.parseDouble(gps[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载mysq驱动
            String url = "jdbc:mysql://120.24.92.204:3306/banche?useUnicode=true&amp;characterEncoding=UTF-8";
//            String url = "jdbc:mysql://127.0.0.1:3306/banche?useUnicode=true&amp;characterEncoding=UTF-8";
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
            System.out.println("wo qi dong l ");
            ServerSocket ss = new ServerSocket(6780);
            while (a == 1) {
                Socket s = ss.accept();
//                new ServiceSocket6780(s).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String changtobaidu(double x, double y) throws Exception {
        String qurl = "http://api.map.baidu.com/geoconv/v1/?"
                + "coords=" + x + "," + y
                + "&from=1&to=5"
                + "&ak=N6Gm1gUPzEHvG2KwIWcHsbVw"
                + "&output=xml";
        SAXReader reader = new SAXReader();
        Document document = reader.read(new URL(qurl));
        Element rootElement = document.getRootElement();
        Element resultElement = rootElement.element("result").element("point");
        Element xElement = resultElement.element("x");
        Element yElement = resultElement.element("y");
        return xElement.getTextTrim() + "," + yElement.getTextTrim();
    }

}
