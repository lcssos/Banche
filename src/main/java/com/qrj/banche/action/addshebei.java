package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Shebei;
import com.qrj.banche.entity.Shebeishuxing;
import com.qrj.banche.repository.ShebeiMapper;
import com.qrj.banche.repository.ShebeishuxingMapper;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component("addshebei")
public class addshebei extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private ShebeiMapper shebeiMapper;

    @Resource
    private ShebeishuxingMapper shebeishuxingMapper;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Shebei shebei = new Shebei();
        shebei.setShebeiId(searchInfo.getAddsheibeiid());
        shebeiMapper.insert(shebei);
        //1是启用，0是停用
        Shebeishuxing shebeishuxing = new Shebeishuxing();
        shebeishuxing.setShebeishuxingShebeiid(searchInfo.getAddsheibeiid());
        shebeishuxing.setShebeishuxingShebeistatus(searchInfo.getAddshebeizhuangtai());
        shebeishuxing.setShebeishuxingShoujihao(searchInfo.getAddshebeishoujihao());
        shebeishuxingMapper.insert(shebeishuxing);
        return "success";
    }

    public addshebei() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
