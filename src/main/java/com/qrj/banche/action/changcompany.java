package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.dao.BancheDao;
import com.qrj.banche.dao.ComdetDao;
import com.qrj.banche.dao.CompanyDao;
import com.qrj.banche.model.Banche;
import com.qrj.banche.model.Comdet;
import com.qrj.banche.model.Company;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("changcompany")
//每一次请求都建个新的action
@Scope("prototype")
public class changcompany extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private CompanyDao companyDao;

    @Resource
    private ComdetDao comdetDao;

    @Resource
    private BancheDao bancheDao;

    private List<Company> companies;

    private List<Comdet> comdets;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        int comid = (Integer) request.getSession().getAttribute("comid");
        if (comid == 0) {
            switch (searchInfo.getSearchcompany()) {
                //查询
                case 1:
                    if (searchInfo.getSearchcomdetname().equals("")) {
                        comdets = comdetDao.findAll();
                    } else {
                        comdets = comdetDao.findByname(searchInfo.getSearchcomdetname());
                    }
                    return "success";
                //更新
                case 2:
                    Comdet comdetq = new Comdet();
                    comdetq.setComdetId(searchInfo.getXiugaicomdetid());
                    comdetDao.delete(comdetq);
                    companies = companyDao.findBycomdetid(searchInfo.getXiugaicomdetid());
                    companyDao.delete(companies.get(0));
                    List<Banche> banches = bancheDao.findBycomdetid(searchInfo.getXiugaicomdetid());
                    for (Banche banche : banches) {
                        banche.setBancheStatus(0);
                        bancheDao.update(banche);
                    }
                    return "success";
                case 3:
                    comdets = comdetDao.findBycomdetId(searchInfo.getXiugaicomdetid());
                    companies = companyDao.findBycomdetid(searchInfo.getXiugaicomdetid());
                    return "xiugai";
                case 4:
                    comdets = comdetDao.findBycomdetId(searchInfo.getXiugaicomdetid());
                    companies = companyDao.findBycomdetid(searchInfo.getXiugaicomdetid());
                    if (comdets.size() > 0 && companies.size() > 0) {
                        Comdet comdet = comdets.get(0);
                        Company company = companies.get(0);
                        comdet.setComdetName(searchInfo.getXiugaicomdetname());
                        comdet.setComdetJianjie(searchInfo.getXiugaicomdetjianjie());
                        comdet.setComdetDizhi(searchInfo.getAddcomdetaddress());
                        comdet.setComdetLianxiren(searchInfo.getXiugaicompanylxname());
                        comdet.setComdetLianxitele(searchInfo.getXiugaicompanylxtele());
                        comdetDao.update(comdet);
                        company.setCompanyName(searchInfo.getXiugaicompanyname());
                        company.setCompanyPassword(searchInfo.getXiugaicompanypass());
                        company.setCompanyLxname(searchInfo.getXiugaicompanylxname());
                        company.setCompanyLxtele(searchInfo.getXiugaicompanylxtele());
                        companyDao.update(company);
                    }
                    comdets = null;
                    companies = null;
                    return "success";
                default:
                    break;
            }
        } else {
            return "faild";
        }
        return "success";
    }

    public changcompany() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Comdet> getComdets() {
        return comdets;
    }

    public void setComdets(List<Comdet> comdets) {
        this.comdets = comdets;
    }
}
