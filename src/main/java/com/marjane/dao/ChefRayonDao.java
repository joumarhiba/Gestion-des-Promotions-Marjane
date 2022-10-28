package com.marjane.dao;

import com.marjane.entities.Promotion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Query;
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
        cr.updatePromo();
       //cr.getPromotions(calendar3.getTime());
    }

    public String getPromotions(Date currentTime){

        String result = "nothing";
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
            if (currentTime.after(calendar1.getTime()) && currentTime.before(calendar2.getTime())) {
                Query qAllP = session.createQuery("FROM Promotion");
                result = "The statics of promotions : ";
                System.out.println(result);
                System.out.println(" -------------------------------");
                List<Promotion> promotionList = qAllP.getResultList();
                System.out.println("********* Le nombre des promotions non-traitées est  :  " + promotionList.stream().filter(i -> i.getStatus() == 0).count());
                System.out.println("********* Le nombre des promotions appliquées est  :  " + promotionList.stream().filter(i -> i.getStatus() == 1).count());
            }
            else {
                result = "The statics of promotions not displayed , time out !";
            System.out.println(result);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        transaction.commit();
        return result;
    }


    public String updatePromo(){
        String str = "";
        int status =0;
        int idP = 21;
        Query qUpdate = session.createQuery("UPDATE Promotion set status =:s  WHERE id=:idP");
        qUpdate.setParameter("s",status);
        qUpdate.setParameter("idP",idP);
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



}
