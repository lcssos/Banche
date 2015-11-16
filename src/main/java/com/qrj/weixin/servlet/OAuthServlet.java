package com.qrj.weixin.servlet;

import com.qrj.banche.repository.WxaccesstokenMapper;
import com.qrj.weixin.pojo.SNSUserInfo;
import com.qrj.weixin.pojo.WeixinOauth2Token;
import com.qrj.weixin.util.AdvancedUtil;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 授权后的回调请求处理
 */
@Component("OAuthServlet")
public class OAuthServlet extends HttpServlet {
    private static final long serialVersionUID = -1847238807216447030L;

//    @Resource
//    private WxaccesstokenMapper wxaccesstokenMapper;

    @Value("#{configProperties['wx.appid']}")
    private String appid;

    @Value("#{configProperties['wx.appsecret']}")
    private String appsecret;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String wxcomid = request.getParameter("state");
        // 用户同意授权
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            //TODO 页面上写点击地址是这个Servlet 更换APPID APPSECRET 为班车在哪的
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(appid, appsecret, code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
//            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
            request.setAttribute("openId", openId);
            request.getSession().setAttribute("openId", openId);
            request.getSession().setAttribute("wxcomid", wxcomid);
//            HttpServletRequest servletrequest = ServletActionContext.getRequest();
//            servletrequest.getSession().setAttribute("openId", openId);
        }
        // 跳转到index.jsp
        request.getRequestDispatcher("test.jsp").forward(request, response);
    }
}
/**
 * 页面上这样取值
 * <body>
 * <%
 * // 获取由OAuthServlet中传入的参数
 * SNSUserInfo user = (SNSUserInfo)request.getAttribute("snsUserInfo");
 * if(null != user) {
 * %>
 * <table width="100%" cellspacing="0" cellpadding="0">
 * <tr><td width="20%">属性</td><td width="80%">值</td></tr>
 * <tr><td>OpenID</td><td><%=user.getOpenId()%></td></tr>
 */