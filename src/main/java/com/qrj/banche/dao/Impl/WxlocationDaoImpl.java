package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.WxlocationDao;
import com.qrj.banche.model.Wxlocation;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("WxlocationDao")
public class WxlocationDaoImpl implements WxlocationDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Wxlocation wxlocation) {
        sessionFactory.getCurrentSession().save(wxlocation);
    }

    @Override
    public void update(Wxlocation wxlocation) {
        sessionFactory.getCurrentSession().update(wxlocation);
    }

    @Override
    public void delete(Wxlocation wxlocation) {
        sessionFactory.getCurrentSession().delete(wxlocation);
    }

    @Override
    public List<Wxlocation> findByopenId(String openId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Wxlocation w where w.openId='" + openId + "'");
        return query.list();
    }
}
