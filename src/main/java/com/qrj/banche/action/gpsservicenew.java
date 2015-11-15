package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.util.ServiceSocket6780;
import com.qrj.banche.util.ServiceSocketGT02A;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.ServerSocket;
import java.net.Socket;


@Component("gpsservicenew")
public class gpsservicenew extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    private int a = 1;

    @Scheduled(cron = "0 5 6 * * ?")
    public void test() throws Exception {
//        HttpServletRequest request = ServletActionContext.getRequest();

        try {
            Object o = new Object();
            System.out.println("wo qi dong l ");
//            ServerSocket ss = new ServerSocket(8841);
//            ServerSocket sss = new ServerSocket(6780);
            ServerSocket sas = new ServerSocket(7741);
            while (a == 1) {
//                Socket s = ss.accept();
//                Socket b = sss.accept();
                Socket c = sas.accept();

//                new ServiceSocket(s,o).start();
//                new ServiceSocket6780(b,o).start();
                new ServiceSocketGT02A(c,o).start();
//                o.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public gpsservicenew() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
