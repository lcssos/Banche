package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.dao.CompanyDao;
import com.qrj.banche.dao.UserDao;
import com.qrj.banche.dao.ZhandianDao;
import com.qrj.banche.model.Company;
import com.qrj.banche.model.User;
import com.qrj.banche.model.Zhandian;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("denglu")
public class denglu extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private UserDao userDao;

    @Resource
    private CompanyDao companyDao;

    private int a = 1;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        if (searchInfo.getTuichu() == 1) {
            request.getSession().setAttribute("userid", null);
            searchInfo.setTuichu(0);
            return "faild";
        }
        List<User> users = userDao.findByUsernameAndPasswork(searchInfo.getUsername(), searchInfo.getPassword());
        if (users.size() > 0) {
            request.getSession().setAttribute("username", users.get(0).getUserName());
            request.getSession().setAttribute("userid", users.get(0).getUserId());
            request.getSession().setAttribute("comid", 0);
            return "success";
        } else {
            List<Company> companies = companyDao.findByNameAndPassword(searchInfo.getUsername(), searchInfo.getPassword());
            if (companies.size() > 0) {
                request.getSession().setAttribute("username", companies.get(0).getCompanyName());
                request.getSession().setAttribute("userid", companies.get(0).getCompanyId());
                request.getSession().setAttribute("comid", companies.get(0).getCompanyId());
                return "success";
            }
        }
        return "faild";
    }

    public denglu() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
