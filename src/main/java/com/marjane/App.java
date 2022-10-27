package com.marjane;

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

// ADD ADMIN
        Admin admin = new Admin();
        admin.setEmail("testingHashhhh@gmail.com");
        admin.setPassword("123456");
        String pwd = admin.getPassword();
        CryptPwd cp = new CryptPwd();
        String hashedP = cp.cryptage(pwd);
        admin.setPassword(hashedP);
        session.persist(admin);

// ADD ADMIN IN CENTER  BY ADMINGeneral
        Center c = new Center();
        c.setVille("casablanca");
        c.setAdmin(admin);
        session.persist(c);


        // ADD category
        Category cat = new Category();
        cat.setName("multimedia");
         session.persist(cat);

        // ADD ChefRayon
       ChefRayon cr = new ChefRayon();
        cr.setEmail("chefElectroniqueee@gmail.com");
        cr.setPassword("123456");
        cr.setCenter(c);
        cr.setCategoryId(cat.getId());
        session.persist(cr);

       //ADD PROMOTION
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date date = cal.getTime();
        Promotion promotion = new Promotion();
        promotion.setDate(date);
        promotion.setPromo(39.00);
        promotion.setCategory(cat);
        promotion.setCenter(c);
        if(promotion.getCategory().getName().equalsIgnoreCase("multimedia") && promotion.getPromo() > 20.00){
            System.out.println(" les promotion sur la categorie multimédia ne doit pas dépasser 20%");
            transaction.rollback();
        }
        else{
            System.out.println(" the promotion is added successful");
        session.persist(promotion);
        }

        //getCenterAdmins

       List<Admin> admins = session.createQuery("from Admin").list();
       List aList = session.createSQLQuery("SELECT * From admin").list();
       //lambda
        admins.forEach((item) -> {
            System.out.println("admin email : "+item.getEmail());
        });

        /*for (Iterator iterator = admins.iterator(); iterator.hasNext();){
            Admin a = new Admin();
            if(iterator.hasNext()){
                System.out.println("First Name: " + a.getEmail());
                System.out.println("  Last Name: " + a.getPassword());
            }
        }*/


    //GET LIST PROMOS BY CENTER_ID


        Query q= session.getNamedQuery("Promotion.byCenter");
        q.setParameter(1, 1);
        List<Promotion> promos = (List<Promotion>) q.getResultList();
        for(Promotion promo : promos){
            System.out.println("LA poromotion est : "+promo.getPromo()+"%");
        }

//delete the admin center
      /*  Query query = session.createQuery("DELETE FROM Admin a where a.id=?1");
        query.setParameter(1,36);
        int row = query.executeUpdate();
        if(row >0){
            System.out.println("DEleteeeeeeeeeeeeeeeeeed");
        }else {
            System.out.println("this admin not found");
        }*/

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
