package com.qrj.banche.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;

    static {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder
                .build();
        sf = cfg.buildSessionFactory(standardServiceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }
}
