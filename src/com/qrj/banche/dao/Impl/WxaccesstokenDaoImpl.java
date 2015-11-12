package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.WxaccesstokenDao;
import com.qrj.banche.model.Wxaccesstoken;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("Wxaccesstoken")
public class WxaccesstokenDaoImpl implements WxaccesstokenDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Wxaccesstoken wxaccesstoken) {
        sessionFactory.getCurrentSession().save(wxaccesstoken);
    }

    @Override
    public void update(Wxaccesstoken wxaccesstoken) {
        sessionFactory.getCurrentSession().update(wxaccesstoken);
    }

    @Override
    public void delete(Wxaccesstoken wxaccesstoken) {
        sessionFactory.getCurrentSession().delete(wxaccesstoken);
    }

    @Override
    public List<Wxaccesstoken> findByid(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Wxaccesstoken w where w.id='" + id + "'");
        return query.list();
    }

    @Override
    public List<Wxaccesstoken> findall() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Wxaccesstoken w");
        return query.list();
    }
}
