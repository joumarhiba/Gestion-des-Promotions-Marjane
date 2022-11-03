package com.marjane.dao;

import com.marjane.entities.Center;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class CenterDao {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session  = sessionFactory.openSession();
    Transaction transaction =session.beginTransaction();

    public static void main(String[] args) {
    }

    public void addCenter(Center center){

        session.persist(center);
        transaction.commit();
    }

    public List getCenters(){
        List<Center> centers = session.createQuery("from Center").list();
        transaction.commit();
        //lambda
        centers.forEach((item) -> {
            System.out.println("center id : "+item.getId());
        });
        return centers;
    }

}

