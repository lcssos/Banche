package com.qrj.weixin.service;

import com.qrj.banche.dao.WxlocationDao;
import com.qrj.banche.entity.Wxlocation;
import com.qrj.banche.model.Wxlocation;
import com.qrj.banche.repository.WxlocationMapper;
import com.qrj.weixin.message.resp.TextMessage;
import com.qrj.weixin.util.MessageUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 核心服务类
 */
@Service
@Scope("prototype")
public class CoreService {

    @Resource
    private WxlocationMapper wxlocationMapper;

    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return xml
     */
    public String processRequest(HttpServletRequest request) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        try {
            // 调用parseXml方法解析请求消息
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String openId = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(openId);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

                respContent = "感谢您的意见！";
                // 设置文本消息的内容
                textMessage.setContent(respContent);
                // 将文本消息对象转换成xml
                respXml = MessageUtil.messageToXml(textMessage);
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 语音消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是语音消息！";
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 关注
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "您好，欢迎关注班车在哪微信公众号，我们为广大企事业单位提供班车线路，站点，实时位置的查询。提高乘车人的坐车体验是我们的使命，欢迎站内留言反馈意见，同时也征集班车线索，电话：010-80222261";
                }
                // 取消关注
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    //  取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
                }
                // 扫描带参数二维码
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // 处理扫描带参数二维码事件
                }
                // 上报地理位置
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    String Longitude = requestMap.get("Longitude");
                    String Latitude = requestMap.get("Latitude");
                    String baidujingweidu = changtobaidu(Double.parseDouble(Longitude), Double.parseDouble(Latitude));

                    List<Wxlocation> wxlocations = wxlocationDao.findByopenId(openId);
                    if (wxlocations.size() > 0) {
                        wxlocations.get(0).setJingdu(Double.parseDouble(baidujingweidu.split(",")[0]));
                        wxlocations.get(0).setWeidu(Double.parseDouble(baidujingweidu.split(",")[1]));
                        wxlocationDao.update(wxlocations.get(0));
                    } else {
                        Wxlocation wxlocation = new Wxlocation();
                        wxlocation.setOpenid(openId);
                        wxlocation.setJingdu(Double.parseDouble(baidujingweidu.split(",")[0]));
                        wxlocation.setWeidu(Double.parseDouble(baidujingweidu.split(",")[1]));
                        wxlocationDao.save(wxlocation);
                    }
//                    respContent = "<a href='http://120.24.92.204/Banche/weixin/zhanshi2.jsp?openId=" + openId + "'>rtrt</a>";
                }
                // 自定义菜单
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    //  处理菜单点击事件
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

    private static String changtobaidu(double x, double y) throws Exception {
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
}
