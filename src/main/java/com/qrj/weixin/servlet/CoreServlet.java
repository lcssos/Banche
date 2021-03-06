package com.qrj.weixin.servlet;

import com.qrj.banche.entity.Wxaccesstoken;
import com.qrj.banche.repository.WxaccesstokenMapper;
import com.qrj.weixin.service.CoreService;
import com.qrj.weixin.util.CommonUtil;
import com.qrj.weixin.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求处理的核心类
 */
@Component("CoreServlet")
@Scope("prototype")
public class CoreServlet extends HttpServlet {
    private static final long serialVersionUID = 4440739483644821986L;
    Logger logger = LoggerFactory.getLogger(CoreServlet.class);

    @Resource
    private CoreService coreService;

    @Resource
    private WxaccesstokenMapper wxaccesstokenMapper;


    @Value("#{configProperties['wx.appid']}")
    private String appid;

    @Value("#{configProperties['wx.appsecret']}")
    private String appsecret;

    /**
     * 请求校验（确认请求来自微信服务器）
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkaccessToken();
//		String respXml = coreService.processRequest(request);
        // 微信加密签名
        String signature = request.getParameter("signature");
        logger.info("signature:"+signature);
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        logger.info("timestamp:"+timestamp);
        // 随机数
        String nonce = request.getParameter("nonce");
        logger.info("nonce:"+nonce);
        // 随机字符串
        String echostr = request.getParameter("echostr");
        logger.info("echostr:"+echostr);

        PrintWriter out = response.getWriter();
        // 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }

    private void checkaccessToken() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("HH");
        String time = dateFormat.format(calendar.getTime());
        List<Wxaccesstoken> wxaccesstokens = wxaccesstokenMapper.findall();
        if (wxaccesstokens.size() > 0) {
            Wxaccesstoken wxaccesstoken = wxaccesstokens.get(0);
            if (Integer.parseInt(wxaccesstoken.getExpirestime()) - Integer.parseInt(time) <= 2 && Integer.parseInt(wxaccesstoken.getExpirestime()) - Integer.parseInt(time) > 0) {

            } else {
                //当数据库中的accessToken和当前时间差在两小时外
                String accessToken = CommonUtil.getToken(appid, appsecret).getAccessToken();
                wxaccesstoken.setAccessToken(accessToken);
                wxaccesstoken.setExpirestime(String.valueOf((Integer.parseInt(time) + 2)));
                wxaccesstokenMapper.updateByPrimaryKeySelective(wxaccesstoken);

                String jsapi_ticket = CommonUtil.getJsticket(accessToken).getJsapiticket();
                wxaccesstokens.get(1).setAccessToken(jsapi_ticket);
                wxaccesstokens.get(1).setExpirestime(String.valueOf((Integer.parseInt(time) + 2)));
            }
        } else {
            //当数据库中没有accessToken时
            String accessToken = CommonUtil.getToken(appid, appsecret).getAccessToken();
            Wxaccesstoken wxaccesstoken = new Wxaccesstoken();
            wxaccesstoken.setAccessToken(accessToken);
            wxaccesstoken.setExpirestime(String.valueOf((Integer.parseInt(time) + 2)));
            wxaccesstokenMapper.insert(wxaccesstoken);

            String jsapi_ticket = CommonUtil.getJsticket(accessToken).getJsapiticket();
            Wxaccesstoken jsapi  = new Wxaccesstoken();
            jsapi.setAccessToken(jsapi_ticket);
            jsapi.setExpirestime(String.valueOf((Integer.parseInt(time) + 2)));
            wxaccesstokenMapper.insert(jsapi);
        }
    }

    /**
     * 请求校验与处理
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkaccessToken();
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 接收参数微信加密签名、 时间戳、随机数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        PrintWriter out = response.getWriter();
        // 请求校验
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            // 调用核心服务类接收处理请求
            String respXml = coreService.processRequest(request);
            out.print(respXml);
        }
        out.close();
        out = null;
    }

}
