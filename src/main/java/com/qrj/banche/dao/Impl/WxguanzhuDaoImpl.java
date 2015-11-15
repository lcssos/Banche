package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.WxguanzhuDao;
import com.qrj.banche.model.Wxguanzhu;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("WxguanzhuDao")
public class WxguanzhuDaoImpl implements WxguanzhuDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Wxguanzhu wxguanzhu) {
        sessionFactory.getCurrentSession().save(wxguanzhu);
    }

    @Override
    public void update(Wxguanzhu wxguanzhu) {
        sessionFactory.getCurrentSession().update(wxguanzhu);
    }

    @Override
    public void delete(Wxguanzhu wxguanzhu) {
        sessionFactory.getCurrentSession().delete(wxguanzhu);
    }
}
