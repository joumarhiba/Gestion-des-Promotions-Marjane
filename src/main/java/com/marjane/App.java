package com.marjane.dao;

import com.marjane.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import javax.persistence.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session  = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("connect");
        EntityManager em = emf.createEntityManager();


        // ADD ADMINGeneral
     /*   AdminGen adminG = new AdminGen();
        adminG.setEmail("supAdmin@gmail.com");
        adminG.setPassword("12345678");
        session.persist(adminG);*/

//ADMIN
        Admin admin = new Admin();
        admin.setEmail("adminCenter@gmail.com");
        admin.setPassword("123456");

// ADMIN IN CENTER  BY ADMINGeneral
        Center c = new Center();
        c.setVille("Safi");
        c.setAdmin(admin);


        // category
        Category cat = new Category();
        cat.setName("alimentation2");

        // ADD ChefRayon
       ChefRayon cr = new ChefRayon();
        cr.setEmail("chefCooking@gmail.com");
        cr.setPassword("123456");
        cr.setRole(3);
        cr.setCenter(c);
        cr.setCategoryId(cat.getId());
        session.persist(cr);

       //ADD PROMOTION
       /* Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date date = cal.getTime();
        Promotion promotion = new Promotion();
        promotion.setDate(date);
        promotion.setPromo(45.00);
        promotion.setCategory(cat);
        promotion.setCenter(c);
        if(promotion.getCategory().getName().equalsIgnoreCase("multimedia") && promotion.getPromo() > 20.00){
            System.out.println(" les promotions sur la categorie multimédia ne doivent pas dépasser 20%");
            transaction.rollback();
        }
        else if(promotion.getPromo() > 50.00) {
            System.out.println(" les promotions ne doivent pas dépasser 50% sur l'ensemble des catégories");
            transaction.rollback();
        }else{
        //session.persist(promotion);
            System.out.println(" the promotion is added successful");
        }
*/

        //JOINTURE en Category & Promotion non appliquée
        Query q2 = session.createQuery("From Category as c INNER JOIN c.promotions as p WHERE status = 0");
        List<Object[]> l = q2.getResultList();

        l.forEach((i) -> {
            System.out.println(Arrays.stream(i).count()+ " promos non-appliquées");
            System.out.println(i);
        });

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

}
