package com.marjane.dao;

import com.marjane.entities.Admin;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionDao {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session  = sessionFactory.openSession();
    Transaction transaction =session.beginTransaction();

    public static void main(String[] args) throws ParseException {
        PromotionDao p = new PromotionDao();
      //  p.listPromotionByIdCategory();
      p.addPromotion();
    }


    public void addPromotion() throws ParseException {

        // instancier un admin
        Admin admin = new Admin();
        admin.setEmail("adminCenter@gmail.com");
        admin.setPassword("123456");

        //instancier une categorie
        Category cat = new Category();
        cat.setName("multimedia");

        //instancier center
        Center c = new Center();
        c.setVille("Safi");
        c.setAdmin(admin);

        //add promotion
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date datedd = cal.getTime();
        String sDate1="2022/12/01";
        Date date=new SimpleDateFormat("yyyy/mm/dd").parse(sDate1);
        Promotion promotion = new Promotion();
        promotion.setDate(datedd);
        promotion.setPromo(15.00);
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
            session.persist(promotion);
            transaction.commit();
            session.close();
            sessionFactory.close();
            System.out.println(" the promotion is added successful");
        }

    }


    public void listPromotionByIdCategory() throws ParseException {
        //instancier une categorie
        Category cat = new Category();
        cat.setName("multimedia");
        Query qP = session.createQuery("FROM Promotion p");
       // Query q= session.getNamedQuery("Promotion.byCategory");

       List<Promotion> promos = (List<Promotion>) qP.getResultList();
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String time = formatter.format(new Date());
        Date date1=new SimpleDateFormat("HH:mm").parse(time);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date1);
        calendar3.add(Calendar.DATE, 1);


        for(Promotion promo : promos){
                System.out.println("promo  = " + promo.getPromo() + "date d'expiration " + promo.getDate());
            //cats.forEach((c) -> System.out.println("la promotion affecté sur la categorie : "+ c.getName()+" est "+promo.getPromo()+" %"));
            //System.out.println("LA promotion est : "+);

       }
    }


}
