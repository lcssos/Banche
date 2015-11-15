package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.CompanyDao;
import com.qrj.banche.model.Company;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("CompanyDao")
public class CompanyDaoImpl implements CompanyDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Company company) {
        sessionFactory.getCurrentSession().save(company);
    }

    @Override
    public void update(Company company) {
        sessionFactory.getCurrentSession().update(company);
    }

    @Override
    public void delete(Company company) {
        sessionFactory.getCurrentSession().delete(company);
    }

    @Override
    public List<Company> findByNameAndPassword(String comname, String compassword) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Company c where c.companyName='" + comname + "' and c.companyPassword='" + compassword + "'");
        return query.list();
    }

    @Override
    public List<Company> findBycomdetid(int comdetid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Company c where c.comdetId='" + comdetid + "'");
        return query.list();
    }
}
