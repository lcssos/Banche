package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.ShebeishuxingDao;
import com.qrj.banche.model.Shebeishuxing;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("ShebeishuxingDao")
public class ShebeishuxingDaoImpl implements ShebeishuxingDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Shebeishuxing shebeishuxing) {
        sessionFactory.getCurrentSession().save(shebeishuxing);
    }

    @Override
    public void update(Shebeishuxing shebeishuxing) {
        sessionFactory.getCurrentSession().update(shebeishuxing);
    }

    @Override
    public void delete(Shebeishuxing shebeishuxing) {
        sessionFactory.getCurrentSession().delete(shebeishuxing);
    }

    @Override
    public List<Shebeishuxing> findByshebeiid(long shebeiid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Shebeishuxing s where s.shebeishuxingShebeiid='" + shebeiid + "'");
        return query.list();
    }

    @Override
    public List<Shebeishuxing> findByshebeiIdandStatus(long shebeiid, int status) {
        Query query = null;
        if (shebeiid == 0) {
            query = sessionFactory.getCurrentSession().createQuery("from Shebeishuxing s where shebeishuxingShebeistatus='" + status + "'");
        } else {
            query = sessionFactory.getCurrentSession().createQuery("from Shebeishuxing s where shebeishuxingShebeiid='" + shebeiid + "'and shebeishuxingShebeistatus='" + status + "'");
        }
        return query.list();
    }
}
