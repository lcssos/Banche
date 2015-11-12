package com.qrj.banche.vo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private static int a = 1;

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8841);
        System.out.println("wo qi dong l");
        while (a == 1) {
            Socket s = ss.accept();
            System.out.println("我执行了");
            InputStream ips = s.getInputStream();
            OutputStream ops = s.getOutputStream();

            byte[] buf = new byte[1024];
            int len = ips.read(buf);
            System.out.println(new String(buf, 0, len));
            Thread.sleep(3000);
            System.out.println("1");
            ops.write("hello,World!".getBytes());
            ops.flush();
            System.out.println("2");

//            ops.close();
//            s.close();
        }
//        ss.close();
    }
}