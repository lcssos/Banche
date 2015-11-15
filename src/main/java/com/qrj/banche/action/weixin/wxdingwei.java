package com.qrj.banche.action.weixin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Wxlocation;
import com.qrj.banche.repository.WxlocationMapper;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

@Component("wxdingwei")
public class wxdingwei extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private WxlocationMapper wxlocationMapper;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String openId = (String)request.getSession().getAttribute("openId");

        Document document = DocumentHelper.createDocument();
        Element rootelement = document.addElement("Message");
        Element errorelement = rootelement.addElement("error");

        String baidujingweidu = changtobaidu(searchInfo.getWxjsjingdu(), searchInfo.getWxjsweidu());
        List<Wxlocation> wxlocations = wxlocationMapper.findByopenId(openId);
        if (wxlocations.size() > 0) {
            wxlocations.get(0).setJingdu(Double.parseDouble(baidujingweidu.split(",")[0]));
            wxlocations.get(0).setWeidu(Double.parseDouble(baidujingweidu.split(",")[1]));
            wxlocationMapper.updateByPrimaryKeySelective(wxlocations.get(0));
        } else {
            Wxlocation wxlocation = new Wxlocation();
            wxlocation.setOpenid(openId);
            wxlocation.setJingdu(Double.parseDouble(baidujingweidu.split(",")[0]));
            wxlocation.setWeidu(Double.parseDouble(baidujingweidu.split(",")[1]));
            wxlocationMapper.insert(wxlocation);
        }
        errorelement.addText("success");
        returnxml(document);
        return null;
    }

    public wxdingwei() {

    }
    /**
     * 返回结果XML给WEB
     *
     * @param document 需要返回给WEB的XML
     * @throws java.io.IOException
     * @author 刘健
     */
    private void returnxml(Document document) throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/xml;charset=gbk"); // （1）一定要在（2）的前面，不然会乱码
        response.setCharacterEncoding("GBK"); // （2）
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter(); // （3）一定要在（1）（2）的后面
        out.print(document.asXML());
        out.flush();
        out.close();
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

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
