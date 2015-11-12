package com.qrj.banche.vo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("192.168.1.163", 8841);
        while (true) {

            InputStream ips = s.getInputStream();
            OutputStream ops = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(ops);
            BufferedReader brNet = new BufferedReader(new InputStreamReader(ips));

            String strWord = "0x780x780x0D0x010x230x450x670x890x010x230x450x000x010x8c0xDD0x0D0x0A";
            dos.write(strWord.getBytes());
            System.out.println(brNet.readLine());
        }
//        dos.close();
//        brNet.close();
//        s.close();
    }
}