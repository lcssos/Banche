package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.dao.ShebeiDao;
import com.qrj.banche.dao.ShebeishuxingDao;
import com.qrj.banche.dao.ZhandianDao;
import com.qrj.banche.model.Shebei;
import com.qrj.banche.model.Shebeishuxing;
import com.qrj.banche.model.Zhandian;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component("addshebei")
public class addshebei extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private ShebeiDao shebeiDao;

    @Resource
    private ShebeishuxingDao shebeishuxingDao;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Shebei shebei = new Shebei();
        shebei.setShebeiId(searchInfo.getAddsheibeiid());
        shebeiDao.save(shebei);
        //1是启用，0是停用
        Shebeishuxing shebeishuxing = new Shebeishuxing();
        shebeishuxing.setShebeishuxingShebeiid(searchInfo.getAddsheibeiid());
        shebeishuxing.setShebeishuxingShebeistatus(searchInfo.getAddshebeizhuangtai());
        shebeishuxing.setShebeishuxingShoujihao(searchInfo.getAddshebeishoujihao());
        shebeishuxingDao.save(shebeishuxing);
        return "success";
    }

    public addshebei() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
