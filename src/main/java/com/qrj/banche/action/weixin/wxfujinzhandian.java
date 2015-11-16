package com.qrj.banche.action.weixin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.repository.FunctionMapper;
import com.qrj.banche.repository.ZhandianMapper;
import com.qrj.banche.vo.SearchInfo;
import com.qrj.banche.vo.Wxgeo;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component("wxfujinzhandian")
@Scope("prototype")
public class wxfujinzhandian extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

//    @Resource
//    private ZhandianMapper zhandianMapper;
    @Resource
    private FunctionMapper functionMapper;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        //前一个属性为附近几公里的站点
        //todo
        List<Wxgeo> zhandians = functionMapper.callwxgeo(5, searchInfo.getWxopenId());
        Document document = DocumentHelper.createDocument();
        Element rootelement = document.addElement("Message");
        Element zhandianselement = rootelement.addElement("Zhandians");
        for (Wxgeo zhandian : zhandians) {
            Element zhandianelement = zhandianselement.addElement("Zhandian");
            Element banchenameelement = zhandianelement.addElement("Banchename");
            banchenameelement.addText(zhandian.getBancheName());
            Element zhandiannameelement = zhandianelement.addElement("Zhandianname");
            zhandiannameelement.addText(zhandian.getZhandianName());
            Element zhandianjingduelement = zhandianelement.addElement("Zhandianjingdu");
            zhandianjingduelement.addText(String.valueOf(zhandian.getZhandianJingdu()));
            Element zhandianweiduelement = zhandianelement.addElement("Zhandianweidu");
            zhandianweiduelement.addText(String.valueOf(zhandian.getZhandianWeidu()));
            Element zhandiandizhielement = zhandianelement.addElement("Zhandiandizhi");
            zhandiandizhielement.addText(zhandian.getZhandianDizhi());
            Element zhandianmiaoshuelement = zhandianelement.addElement("Zhandianmiaoshu");
            zhandianmiaoshuelement.addText(zhandian.getZhandianMiaoshu());
        }
        returnxml(document);

        return null;
    }

    public wxfujinzhandian() {

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
    @Override
    public Object getModel() {
        return searchInfo;
    }
}
