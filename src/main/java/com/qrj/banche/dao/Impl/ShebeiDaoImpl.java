package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.ShebeiDao;
import com.qrj.banche.model.Shebei;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("ShebeiDao")
public class ShebeiDaoImpl implements ShebeiDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Shebei shebei) {
        sessionFactory.getCurrentSession().save(shebei);
    }

    @Override
    public void update(Shebei shebei) {
        sessionFactory.getCurrentSession().update(shebei);
    }

    @Override
    public void delete(Shebei shebei) {
        sessionFactory.getCurrentSession().delete(shebei);
    }

    @Override
    public List<Shebei> findByshebeiIdandStatus(long shebeiid, int status) {
        Query query = null;
        if (shebeiid == 0) {
            query = sessionFactory.getCurrentSession().createQuery("from Shebei s where s.shebeiStatus='" + status + "'");
        } else {
            query = sessionFactory.getCurrentSession().createQuery("from Shebei s where s.shebeiId='" + shebeiid + "' and s.shebeiStatus='" + status + "'");
        }
        return query.list();
    }

    @Override
    public List<Shebei> findByshebeiId(long shebeiid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Shebei  s where s.shebeiId='" + shebeiid + "'");
        return query.list();
    }

    @Override
    public List<Shebei> fingByshebeiids(long[] shebeiid) {
        Query query = null;
        String hql = "from Shebei s where s.shebeiId='" + shebeiid[0] + "'";
        if (shebeiid.length > 1) {
            for (int i = 1; i < shebeiid.length; i++) {
                hql = hql + " or shebeiId='" + shebeiid[i] + "'";
            }
        }
        query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}
