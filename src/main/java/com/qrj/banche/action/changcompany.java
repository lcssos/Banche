package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Banche;
import com.qrj.banche.entity.Comdet;
import com.qrj.banche.entity.Company;
import com.qrj.banche.repository.BancheMapper;
import com.qrj.banche.repository.ComdetMapper;
import com.qrj.banche.repository.CompanyMapper;
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
    private CompanyMapper companyMapper;

    @Resource
    private ComdetMapper comdetMapper;

    @Resource
    private BancheMapper bancheMapper;

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
                        comdets = comdetMapper.findAll();
                    } else {
                        comdets = comdetMapper.findByname(searchInfo.getSearchcomdetname());
                    }
                    return "success";
                //更新
                case 2:
//                    Comdet comdetq = new Comdet();
//                    comdetq.setComdetId(searchInfo.getXiugaicomdetid());
                    comdetMapper.deleteByPrimaryKey(searchInfo.getXiugaicomdetid());
                    companies = companyMapper.findBycomdetid(searchInfo.getXiugaicomdetid());
                    companyMapper.deleteByPrimaryKey(companies.get(0).getCompanyId());
                    List<Banche> banches = bancheMapper.findBycomdetid(searchInfo.getXiugaicomdetid());
                    for (Banche banche : banches) {
                        banche.setBancheStatus(0);
                        bancheMapper.updateByPrimaryKeySelective(banche);
                    }
                    return "success";
                case 3:
                    comdets = comdetMapper.findBycomdetId(searchInfo.getXiugaicomdetid());
                    companies = companyMapper.findBycomdetid(searchInfo.getXiugaicomdetid());
                    return "xiugai";
                case 4:
                    comdets = comdetMapper.findBycomdetId(searchInfo.getXiugaicomdetid());
                    companies = companyMapper.findBycomdetid(searchInfo.getXiugaicomdetid());
                    if (comdets.size() > 0 && companies.size() > 0) {
                        Comdet comdet = comdets.get(0);
                        Company company = companies.get(0);
                        comdet.setComdetName(searchInfo.getXiugaicomdetname());
                        comdet.setComdetJianjie(searchInfo.getXiugaicomdetjianjie());
                        comdet.setComdetDizhi(searchInfo.getAddcomdetaddress());
                        comdet.setComdetLianxiren(searchInfo.getXiugaicompanylxname());
                        comdet.setComdetLianxitele(searchInfo.getXiugaicompanylxtele());
                        comdetMapper.updateByPrimaryKeySelective(comdet);
                        company.setCompanyName(searchInfo.getXiugaicompanyname());
                        company.setCompanyPassword(searchInfo.getXiugaicompanypass());
                        company.setCompanyLxname(searchInfo.getXiugaicompanylxname());
                        company.setCompanyLxtele(searchInfo.getXiugaicompanylxtele());
                        companyMapper.updateByPrimaryKeySelective(company);
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
