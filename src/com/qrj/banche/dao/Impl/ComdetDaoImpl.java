package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.ComdetDao;
import com.qrj.banche.model.Comdet;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("ComdetDao")
public class ComdetDaoImpl implements ComdetDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Comdet comdet) {
        sessionFactory.getCurrentSession().save(comdet);
    }

    @Override
    public void update(Comdet comdet) {
        sessionFactory.getCurrentSession().update(comdet);
    }

    @Override
    public void delete(Comdet comdet) {
        sessionFactory.getCurrentSession().delete(comdet);
    }

    @Override
    public List<Comdet> findByname(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comdet c where c.comdetName='" + name + "'");
        return query.list();
    }

    @Override
    public List<Comdet> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comdet");
        return query.list();
    }

    @Override
    public List<Comdet> findBycomdetId(int comdetid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Comdet c where c.comdetId='" + comdetid + "'");
        return query.list();
    }
}
