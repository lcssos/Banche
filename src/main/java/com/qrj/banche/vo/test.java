package com.qrj.banche.vo;


import com.qrj.banche.util.ServiceSocket;
import com.qrj.banche.util.ServiceSocket6780;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test{
    public static String urlEncode(String source) {
        String result = source;
        try {
            result = URLEncoder.encode(source, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
//        String dsf = "http://www.banchezaina.com/Banche/OAuthServlet";
//        System.out.println(urlEncode(dsf));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date now = new Date();
//        System.out.println("当前时间：" + sdf.format(now));
//        Date afterDate = new Date(now .getTime() - 60000);
//        System.out.println(sdf.format(afterDate ));
        System.out.println(100> 100D);
    }

}