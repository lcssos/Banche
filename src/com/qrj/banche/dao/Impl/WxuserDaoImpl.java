package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.WxuserDao;
import com.qrj.banche.model.Wxuser;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("WxuserDao")
public class WxuserDaoImpl implements WxuserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Wxuser wxuser) {
        sessionFactory.getCurrentSession().save(wxuser);
    }

    @Override
    public void update(Wxuser wxuser) {
        sessionFactory.getCurrentSession().update(wxuser);
    }

    @Override
    public void delete(Wxuser wxuser) {
        sessionFactory.getCurrentSession().delete(wxuser);
    }
}
