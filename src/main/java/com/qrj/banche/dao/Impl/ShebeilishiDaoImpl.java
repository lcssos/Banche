package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.ShebeilishiDao;
import com.qrj.banche.model.Shebeilishi;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component("ShebeilishiDao")
public class ShebeilishiDaoImpl implements ShebeilishiDao {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<Shebeilishi> findByshebeiidthelast5(long shebeiid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Shebeilishi s where s.shebeilishiShebeiid='" + shebeiid + "' ORDER BY s.shebeilishiId desc ");
        query.setMaxResults(5);
        return query.list();
    }

    @Override
    public List<Shebeilishi> findByshebeilishishijianandshebeiid(String time, long shebeiid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Shebeilishi s where s.shebeilishiShebeishijian like '%" + time + "%' and shebeilishiShebeiid='" + shebeiid + "' order by s.shebeilishiShebeishijian desc");
        query.setMaxResults(5);
        return query.list();
    }

    @Override
    public List<Shebeilishi> finddayushebeilishishijianandshebeiid(String time, long shebeiid) {
        Query query = this.sessionFactory.getCurrentSession().createQuery("from Shebeilishi s where s.shebeilishiShebeishijian >'" + time + "' and shebeilishiShebeiid='" + shebeiid + "' order by s.shebeilishiShebeishijian");
        query.setMaxResults(2);
        return query.list();
    }

    @Override
    public List<Shebeilishi> findguiji(String startday, String starttime, String endday, String endtime, long shebeiid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Shebeilishi s where s.shebeilishiShebeishijian >= '" + startday + ":" + starttime + "' and s.shebeilishiShebeishijian <= '" + endday + ":" + endtime + "'and s.shebeilishiShebeiid='" + shebeiid + "' order by s.shebeilishiShebeishijian");
        return query.list();
    }

    @Override
    public List<String> findhuodong(String time) {
        Query query = this.sessionFactory.getCurrentSession().createSQLQuery("SELECT DISTINCT shebeilishi_shebeiid as ffd FROM shebeilishi s where s.shebeilishi_shebeishijian>'" + time + "'");
        List testt = query.list();
        List list = new ArrayList();
        for (int i = 0; i < query.list().size(); i++) {
            list.add(i, testt.get(i).toString());
        }
        return list;
    }
}
