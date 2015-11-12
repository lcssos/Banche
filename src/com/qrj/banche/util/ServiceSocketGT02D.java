package com.qrj.banche.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ServiceSocketGT02D extends Thread {

    private static int a = 1;
    public Socket sock;
    private int changdu = 0;
    long shebeiid = 1234;


    public ServiceSocketGT02D(Socket sock) {
        this.sock = sock;
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
                    OutputStream os = sock.getOutputStream();
                    if (len > 0) {
                        for (int i = 0; i < len; i++) {
                                    String aa = Integer.toHexString(buf[i] & 0x000000FF);
                                    if (aa.length() == 1) {
                                        aa = "0" + aa;
                                    }
                                    System.out.print(aa + "  ");
                                }
                        changdu = buf[2];
                        if (heduijiaoyanma(buf)) {
                            switch (buf[3]) {
                                case 1:
                                    //登陆包
                                    shebeiid = denglu(buf, shebeiid);
                                    if (shebeiid != 0) {
                                        byte jiaoyan[] = hexStringToBytes(Integer.toHexString(CRCjiaoyan.GetCrc16(new byte[]{0x05, 0x01, buf[changdu - 1], buf[changdu]})));
                                        if (jiaoyan.length > 1) {
                                            byte denglureturn[] = new byte[]{0x78, 0x78, 0x05, 0x01, buf[changdu - 1], buf[changdu], jiaoyan[0], jiaoyan[1], 0x0D, 0x0A};
                                            os.write(denglureturn);
                                        }
                                        System.out.println("登陆包返回成功");
                                    }
                                    break;
                                case 19:
                                    //状态包
//                                for (int i = 0; i < len; i++) {
//                                    String aa = Integer.toHexString(buf[i] & 0x000000FF);
//                                    if (aa.length() == 1) {
//                                        aa = "0" + aa;
//                                    }
//                                    System.out.print(aa + "  ");
//                                }
                                    byte jiaoyan[] = hexStringToBytes(Integer.toHexString(CRCjiaoyan.GetCrc16(new byte[]{0x05, 0x13, buf[changdu - 1], buf[changdu]})));
                                    if (jiaoyan.length > 1) {
                                        byte zhuangtaireturn[] = new byte[]{0x78, 0x78, 0x05, 0x13, buf[changdu - 1], buf[changdu], jiaoyan[0], jiaoyan[1], 0x0D, 0x0A};
                                        os.write(zhuangtaireturn);
                                    }
                                    System.out.println("状态包返回成功" + shebeiid);
                                    break;
                                case 18:
                                    //gps lbs 合并包
//                                for (int i = 0; i < len; i++) {
//                                    String aa = Integer.toHexString(buf[i] & 0x000000FF);
//                                    if (aa.length() == 1) {
//                                        aa = "0" + aa;
//                                    }
//                                    System.out.print(aa + "  ");
//                                }
                                    gpslbs(buf);
                                    System.out.println("GPS包处理成功" + shebeiid);
                                    break;
                                default:
                                    for (int i = 0; i < len; i++) {
                                        String aa = Integer.toHexString(buf[i] & 0x000000FF);
                                        if (aa.length() == 1) {
                                            aa = "0" + aa;
                                        }
                                        System.out.print(aa + "  ");
                                    }
                                    System.out.println("我是其他信息" + shebeiid);
                                    os.write(new byte[]{0x78});
                                    break;
                            }
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

    public long denglu(byte buf[], long shebeiid) {
        String ss = "";
        for (int i = 0; i < 8; i++) {
            String aa = Integer.toHexString(buf[i + 4] & 0x000000FF);
            if (aa.length() == 1) {
                aa = "0" + aa;
            }
            ss = ss + aa;
        }
        shebeiid = Long.parseLong(ss);
        System.out.println(shebeiid);
        return shebeiid;
    }

    public void gpslbs(byte buf[]) {
        System.out.println();
        String jd = "";
        String wd = "";
        for (int i = 11; i < 15; i++) {
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

        int sudu = Integer.valueOf(Integer.toHexString(buf[19] & 0x000000FF), 16);
        String shijian = "20";
        for (int i = 4; i < 10; i++) {
            String ss = String.valueOf(buf[i]);
            if (ss.length() == 1) {
                ss = "0" + ss;
            }
            shijian = shijian + ss + ":";
        }
        shijian = shijian.substring(0, shijian.length() - 1);


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //加载mysq驱动
            String url = "jdbc:mysql://120.24.92.204:3306/banche?useUnicode=true&amp;characterEncoding=UTF-8";
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

    private double formategps(int zuobiao) {
        double a = Double.parseDouble(String.valueOf(zuobiao)) / 30000.00;
        double b = a % 60;
        int c = (int) Math.floor(a / 60);

        return c + (b / 60);
    }

    public boolean heduijiaoyanma(byte buf[]) {
        byte crc[] = new byte[buf[2] - 1];
        System.arraycopy(buf, 2, crc, 0, buf[2] - 1);
        int jiaoyanma = Integer.valueOf(Integer.toHexString(buf[changdu + 1] & 0x000000FF) + Integer.toHexString(buf[changdu + 2] & 0x000000FF), 16);
        if (CRCjiaoyan.GetCrc16(crc) == jiaoyanma) {
//        if (a ==1) {
            System.out.println("校验码通过");
            return true;
        } else {
            System.out.println("这条数据是粘包");
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("wo qi dong l ");
            ServerSocket ss = new ServerSocket(8841);
            while (a == 1) {
                Socket s = ss.accept();
                new ServiceSocketGT02D(s).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));

        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);

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
