package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.CheliangDao;
import com.qrj.banche.model.Cheliang;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("CheliangDao")
public class CheliangDaoImpl implements CheliangDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Cheliang cheliang) {
        sessionFactory.getCurrentSession().save(cheliang);
    }

    @Override
    public void update(Cheliang cheliang) {
        sessionFactory.getCurrentSession().update(cheliang);
    }

    @Override
    public void delete(Cheliang cheliang) {
        sessionFactory.getCurrentSession().delete(cheliang);
    }

    @Override
    public List<Cheliang> findByChepai(String cheliang_chepai) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.cheliangChepai like '%" + cheliang_chepai + "%'");
        return query.list();
    }

    @Override
    public List<Cheliang> findByChepaiAndcomid(String chepai, int comid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.cheliangChepai like '%" + chepai + "%' and c.comdetId='" + comid + "'");
        return query.list();
    }

    @Override
    public List<Cheliang> findByChepaiAndshebeiIdandcomid(String chepai, long shebeiid, int comid) {
        Query query = null;
        if (chepai.equals("") && shebeiid == 0) {
            query = sessionFactory.getCurrentSession().createQuery("from Cheliang");
        } else if (chepai.equals("")) {
            query = sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.shebeiId='" + shebeiid + "' and c.comdetId='" + comid + "'");
        } else if (shebeiid == 0) {
            query = sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.cheliangChepai like '%" + chepai + "%' and c.comdetId='" + comid + "'");
        }
        return query.list();
    }

    @Override
    public List<Cheliang> findByChepaiAndshebeiId(String chepai, long shebeiid) {
//        Query query = null;
//                sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.cheliangChepai='" + chepai + "' and c.shebeiId='" + shebeiid + "'");
        String hql = "from Cheliang";
        if (chepai.equals("") && shebeiid == 0) {
            hql = hql;
        } else if (chepai.equals("")) {
            hql = hql + " c where c.shebeiId='" + shebeiid + "'";
        } else if (shebeiid == 0) {
            hql = hql + " c where c.cheliangChepai='" + chepai + "'";
        } else {
            hql = hql + " c where c.cheliangChepai='" + chepai + "' and c.shebeiId='" + shebeiid + "'";
        }
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Cheliang> findByCheliangid(int cheliangid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.cheliangId='" + cheliangid + "'");
        return query.list();
    }

    @Override
    public List<Cheliang> findByshebeiid(long shebeiid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.shebeiId='" + shebeiid + "'");
        return query.list();
    }

    @Override
    public List<Cheliang> findByBancheid(int bancheid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Cheliang c where c.bancheId='" + bancheid + "'");
        return query.list();
    }
}
