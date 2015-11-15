package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.BancheDao;
import com.qrj.banche.model.Banche;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("BancheDao")
public class BancheDaoImpl implements BancheDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Banche banche) {
        sessionFactory.getCurrentSession().save(banche);
    }

    @Override
    public void update(Banche banche) {
        sessionFactory.getCurrentSession().update(banche);
    }

    @Override
    public void delete(Banche banche) {
        sessionFactory.getCurrentSession().delete(banche);
    }

    @Override
    public List<Banche> findByBancheNameAndstatus(String banche_name, int status) {
        Query query = null;
        if (banche_name.equals("")) {
            query = sessionFactory.getCurrentSession().createQuery("from Banche b where b.bancheStatus='" + status + "'");
        } else {
            query = sessionFactory.getCurrentSession().createQuery("from Banche b where b.bancheName like '%" + banche_name + "%' and b.bancheStatus='" + status + "'");
        }
        return query.list();
    }

    @Override
    public List<Banche> findByBancheNameAndComidAndstatus(String banche_name, int comdet_id, int status) {
        Query query = null;
        if (banche_name.equals("")) {
            query = sessionFactory.getCurrentSession().createQuery("from Banche b where b.comdetId='" + comdet_id + "' and b.bancheStatus='" + status + "'");
        } else {
            query = sessionFactory.getCurrentSession().createQuery("from Banche b where b.bancheName like '%" + banche_name + "%' and b.comdetId='" + comdet_id + "' and b.bancheStatus='" + status + "'");
        }
        return query.list();
    }

    @Override
    public List<Banche> findByBancheId(int bancheid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Banche b where b.bancheId='" + bancheid + "'");
        return query.list();
    }

    @Override
    public List<Banche> findBycomdetid(int comdetid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Banche b where b.comdetId='" + comdetid + "'");
        return query.list();
    }

    @Override
    public List<Banche> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Banche b");
        return query.list();
    }

}
