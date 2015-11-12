package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.ZhandianDao;
import com.qrj.banche.model.Zhandian;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("ZhandianDao")
public class ZhandianDaoImpl implements ZhandianDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void save(Zhandian zhandian) {
        sessionFactory.getCurrentSession().save(zhandian);
    }

    @Override
    public void update(Zhandian zhandian) {
        sessionFactory.getCurrentSession().update(zhandian);
    }

    @Override
    public void delete(Zhandian zhandian) {
        sessionFactory.getCurrentSession().delete(zhandian);
    }

    @Override
    public List<Zhandian> findByZhandianName(String zhandian_name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Zhandian z where z.zhandianName like '%" + zhandian_name + "%'");
        return query.list();
    }

    @Override
    public List<Zhandian> findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Zhandian z");
        return query.list();
    }

    @Override
    public List<Zhandian> findByBancheId(int bancheid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Zhandian z where z.bancheId='" + bancheid + "' order by z.zhandianXuhao");
        return query.list();
    }

    @Override
    public List<Zhandian> findByBancheIdDESC(int bancheid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Zhandian z where z.bancheId='" + bancheid + "' order by z.zhandianXuhao desc ");
        return query.list();
    }

    @Override
    public List<Zhandian> findByZhandianId(int zhandianid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Zhandian z where z.zhandianId='" + zhandianid + "'");
        return query.list();
    }

    @Override
    public List<Zhandian> findByBancheIdandXuhao(int bancheid, int xuhao) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Zhandian z where z.bancheId='" + bancheid + "' and z.zhandianXuhao='" + xuhao + "'");
        return query.list();
    }

    @Override
    public List<Zhandian> findByBancheIdandyincang(int bancheid, int yincang) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Zhandian z where z.bancheId='" + bancheid + "' and z.zhandianYincang='" + yincang + "' order by z.zhandianXuhao");
        return query.list();
    }

    @Override
    public List<Object[]> callwxgeo(int juli, String openId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("call wxgeo(" + juli + ",'" + openId + "')");
        return query.list();
    }

    @Override
    public List<Object[]> callfujinzd(int juli, String openId, int banchid) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("call fujinzd(" +juli + ",'" + openId + "'," + banchid + ")");
        return query.list();
    }

    @Override
    public List<Object[]> callgeo(int juli, long shebeiId,int bancheid) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("call geo(" + juli + "," + shebeiId + "," + bancheid +")");
        return query.list();
    }

}
