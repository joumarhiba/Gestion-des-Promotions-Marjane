package com.marjane.dao;

import com.marjane.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CategoryDao {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session  = sessionFactory.openSession();
    Transaction transaction =session.beginTransaction();

    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.addCategory();
    }

    public void addCategory(){

        Category cat = new Category();
        cat.setName("Alimentation");
        session.persist(cat);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
