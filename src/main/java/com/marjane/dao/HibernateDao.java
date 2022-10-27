package com.marjane.dao;

import com.marjane.util.HibernateUtil;
import org.hibernate.Session;

public abstract class HibernateDao<T> {
    public void insertEntity(T entity) throws Exception {

        Session session = HibernateUtil.getCurrentSession();
        session.getTransaction();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
    }

}
