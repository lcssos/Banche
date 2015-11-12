package com.qrj.banche.dao.Impl;

import com.qrj.banche.dao.UserDao;
import com.qrj.banche.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("UserDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<User> findByUsernameAndPasswork(String user_name, String user_password) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.userName='" + user_name + "' and u.userPassword='" + user_password + "'");
        return query.list();
    }
}
