package com.marjane.dao;

import com.marjane.entities.Category;
import com.marjane.entities.Center;
import com.marjane.entities.Promotion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PromotionDao {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session  = sessionFactory.openSession();
    Transaction transaction =session.beginTransaction();

    public static void main(String[] args) {
        PromotionDao p = new PromotionDao();
        p.listPromotionByIdCenter();
    }

    public void listPromotionByIdCenter(){
        Query q= session.getNamedQuery("Promotion.byCenter");
        q.setParameter(1, 14);
        List<Promotion> promos = (List<Promotion>) q.getResultList();
        for(Promotion promo : promos){
            System.out.println("LA promotion est : "+promo.getPromo()+"%");
        }
    }


}
