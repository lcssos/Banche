package com.qrj.banche.vo;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class ClientSocket {
    private static Socket s;
    static OutputStream os;
    static InputStream is;
    private static int a = 1;
    private static int b = 1;

    public static void main(String[] args) {
        try {
//            s = new Socket("127.0.0.1", 7741);
                s = new Socket("120.24.92.204", 7741);
            while (a == 1) {
                System.out.println(s.isConnected());
                if (s.isConnected()) {
                } else {
                    s = new Socket("192.168.0.163", 8841);
                }
                os = s.getOutputStream();
                is = s.getInputStream();
                System.out.println("我执行中");
//                    byte Qute[] = new byte[]{0x78, 0x78, 0x0D,0x01, 0x06, 0x10, 0x11, 0x50, 0x71, (byte) 0x60, 0x00, 0x25, 0x29, 0x16, (byte) 0xdb, (byte) 0x4d, (byte) 0x0D, 0x0D, 0x0A};
                byte Qute[] = new byte[]{0x78,0x78,0x0A,0x13,0x44,0x01,0x04,0x00,0x01,0x00,0x05,0x08,0x45,0x0D,0x0A};
//                byte Qute[] = new byte[]{42, 72, 81, 44, 51, 53, 51, 53, 48, 53, 50, 50, 48, 57, 52, 51, 55, 53, 55, 44, 86, 49, 44, 48, 52, 49, 51, 51, 53, 44, 65, 44, 51, 57, 52, 53, 46, 56, 51, 54, 49, 57, 44, 78, 44, 49, 49, 54, 49, 57, 46, 54, 51, 56, 54, 48, 44, 69, 44, 48, 46, 49, 48, 44, 48, 44, 49, 56, 48, 56, 49, 53, 44, 70, 70, 70, 70, 70, 70, 70, 70, 44, 49, 99, 99, 44, 48, 44, 49, 49, 102, 101, 44, 98, 53, 53, 57, 35, 32, 13, 10};
                os.write(Qute);
                System.out.println("1");
//                Thread.sleep(5000);
                byte[] buf = new byte[1024];
                int len = is.read(buf);
                for (int i = 0; i < len; i++) {
                    String aa = Integer.toHexString(buf[i] & 0x000000FF);
                    if (aa.length() == 1) {
                        aa = "0" + aa;
                    }
                    System.out.print(aa + "  ");
                }
                b++;
                if (b == 2) {
                    a = 2;
                }
//                os.close();
//                is.close();
            }
//            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
