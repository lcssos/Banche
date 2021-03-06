package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Comdet;
import com.qrj.banche.entity.Company;
import com.qrj.banche.repository.ComdetMapper;
import com.qrj.banche.repository.CompanyMapper;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("addcompany")
public class addcompany extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private ComdetMapper comdetMapper;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Company company = new Company();
        Comdet comdet = new Comdet();
        comdet.setComdetName(searchInfo.getAddcomdetname());
        comdet.setComdetJianjie(searchInfo.getAddcomdetjianjie());
        comdet.setComdetDizhi(searchInfo.getAddcomdetaddress());
        comdet.setComdetLianxiren(searchInfo.getAddcompanylxname());
        comdet.setComdetLianxitele(searchInfo.getAddcompanylxtele());
        comdetMapper.insert(comdet);
        List<Comdet> comdets = comdetMapper.findByname(searchInfo.getAddcomdetname());
        if (comdets.size() > 0) {
            company.setComdetId(comdets.get(0).getComdetId());
            company.setCompanyLxname(searchInfo.getAddcompanylxname());
            company.setCompanyLxtele(searchInfo.getAddcompanylxtele());
            company.setCompanyName(searchInfo.getAddcompanyname());
            company.setCompanyPassword(searchInfo.getAddcompanypass());
            company.setCompanyQuanxian("1");
            companyMapper.insert(company);
        }
        return "success";
    }

    public addcompany() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
