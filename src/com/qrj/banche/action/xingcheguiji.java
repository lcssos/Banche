package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.dao.CheliangDao;
import com.qrj.banche.dao.CompanyDao;
import com.qrj.banche.dao.ShebeilishiDao;
import com.qrj.banche.dao.UserDao;
import com.qrj.banche.model.Cheliang;
import com.qrj.banche.model.Company;
import com.qrj.banche.model.Shebeilishi;
import com.qrj.banche.model.User;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component("xingcheguiji")
public class xingcheguiji extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private ShebeilishiDao shebeilishiDao;

    @Resource
    private CheliangDao cheliangDao;

    private List<Cheliang> cheliangs;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        int comid = (Integer) request.getSession().getAttribute("comid");


//        String[] sdf = request.getParameterValues("_submit");
        if (comid == 0) {
            cheliangs = cheliangDao.findByChepai(searchInfo.getChepai());
        } else {
            cheliangs = cheliangDao.findByChepaiAndcomid(searchInfo.getChepai(), comid);
        }
        if (cheliangs.size() > 0) {
            List<Shebeilishi> shebeilishis = shebeilishiDao.findguiji(searchInfo.getStartday(), searchInfo.getStarttime(), searchInfo.getEndday(), searchInfo.getEndtime(), cheliangs.get(0).getShebeiId());
            Document document = DocumentHelper.createDocument();
            Element rootelement = document.addElement("Message");
            Element Shebeilishiselement = rootelement.addElement("Shebeilishis");
            for (Shebeilishi shebeilishi : shebeilishis) {
                Element lishielement = Shebeilishiselement.addElement("Shebeilishi");
                Element jingduelement = lishielement.addElement("Jingdu");
                jingduelement.addText(String.valueOf(shebeilishi.getShebeilishiShebeijingdu()));
                Element weiduelement = lishielement.addElement("Weidu");
                weiduelement.addText(String.valueOf(shebeilishi.getShebeilishiShebeiweidu()));
                Element suduelement = lishielement.addElement("Sudu");
                suduelement.addText(String.valueOf(shebeilishi.getShebeilishiShebeisudu()));
                Element shijianelement = lishielement.addElement("Shijian");
                shijianelement.addText(shebeilishi.getShebeilishiShebeishijian());
            }
            returnxml(document);
        } else {
            System.out.println("您没有权限查询该车辆");
        }
        return null;
    }

    public xingcheguiji() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
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
}
