package com.marjane.dao;

import com.marjane.entities.Admin;
import com.marjane.entities.AdminGen;
import com.marjane.entities.ChefRayon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ChefRayonDao {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session  = sessionFactory.openSession();
    Transaction transaction =session.beginTransaction();

    public static void main(String[] args) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String time = formatter.format(new Date());
        Date date1=new SimpleDateFormat("HH:mm").parse(time);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date1);
        calendar3.add(Calendar.DATE, 1);
        ChefRayonDao cr = new ChefRayonDao();
       // cr.updatePromo();
       //cr.getPromotions(calendar3.getTime());
    }


    public int promoInfos(int idCategory){

        String result = null;
        int id = 0;
        try {
            Query getIdPromotion = session.createQuery("SELECT p.id FROM Category as c INNER JOIN c.promotions as p WHERE c.id = :idCategory");
            getIdPromotion.setParameter("idCategory", idCategory);
            id = getIdPromotion.getFirstResult();

        }
        catch(Exception exception){
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        transaction.commit();
        return id;
    }
    public List getPromotions(int idCategory){

        List<Object> promotionList = null;
        String result = null;
        try {
            String string1 = "08:00";
            Date time1 = new SimpleDateFormat("HH:mm").parse(string1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);
            calendar1.add(Calendar.DATE, 1);

            String string2 = "21:00";
            Date time2 = new SimpleDateFormat("HH:mm").parse(string2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);

            //Date x = calendar3.getTime();
         //   if (currentTime.after(calendar1.getTime()) && currentTime.before(calendar2.getTime())) {
                Query qAllP = session.createQuery("SELECT p.promo FROM Category as c INNER JOIN c.promotions as p WHERE c.id = :idCategory");
                qAllP.setParameter("idCategory",idCategory);

                result = "The statics of promotions : ";
                promotionList = qAllP.getResultList();
          //  }
          //  else {
            //    result = "The statics of promotions not displayed , time out !";
           // System.out.println(result);
           // }
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        transaction.commit();
        return promotionList;
    }


    public String updatePromo(int idPromotion){
        String str = "";
        int status =1;
        Query qUpdate = session.createQuery("UPDATE Promotion set status =:s WHERE id=:idP");
        qUpdate.setParameter("s",status);
        qUpdate.setParameter("idP",idPromotion);
        int r = qUpdate.executeUpdate();
        if(r>0){
            str = "La promotion est appliquée mnt !!!!!";
            System.out.println(str);
        }
        else {
            str = "Nooo something wrong the update not applied";
            System.out.println(str);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
        return str;
    }

    public void addChefRayon(ChefRayon chefRayon) throws NoSuchAlgorithmException {

        Admin admin = new Admin();

        session.merge(chefRayon);
        System.out.println("is added as chefff");
        transaction.commit();

    }

    public int validate(String email, String password){

        ChefRayon chefRayon;

        chefRayon = (ChefRayon) session.createQuery("FROM ChefRayon cr WHERE cr.email=:email and cr.password=:password")
                .setParameter("email", email).setParameter("password", password).uniqueResult();

        if(chefRayon != null && chefRayon.getEmail().equals(email) && chefRayon.getPassword().equals((password))) {
            System.out.println("you're logged as chef rayon");
            return chefRayon.getCategoryId();
        }
        transaction.commit();
        return 0;

    }

}
