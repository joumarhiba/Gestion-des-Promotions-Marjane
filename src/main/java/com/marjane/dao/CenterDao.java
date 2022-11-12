package com.marjane.dao;

import com.marjane.entities.Admin;
import com.marjane.entities.Center;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
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

        session.merge(center);
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
    public void updateCenter(String ville, int adminid){

        String str = "";

        Query qUpdate = session.createQuery("update Center set ville=?1 where admin_id=?2");
        qUpdate.setParameter(1,ville);
        qUpdate.setParameter(2,adminid);

        int r = qUpdate.executeUpdate();
        if(r>0){
            str = "La center est modifié mnt !!!!!";
            System.out.println(str);
        }
        else {
            str = "No something wrong the update not applied";
            System.out.println(str);
        }
        transaction.commit();


    }

}

