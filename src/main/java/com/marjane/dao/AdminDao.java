package com.marjane.dao;

import com.marjane.CryptPwd;
import com.marjane.SendEmail;
import com.marjane.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//import javax.mail.MessagingException;
import javax.persistence.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AdminDao {

Admin admin = new Admin();
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session  = sessionFactory.openSession();
    Transaction transaction =session.beginTransaction();
    public static void main(String[] args) throws NoSuchAlgorithmException,  IOException {
        AdminDao ad = new AdminDao();
       //ad.addAdmin();
      // ad.addAdminCenter();
       //ad.getAdmins();
        ad.validate("adminC@gmail.com","123456");
    }

    public void addAdmin(Admin admn) throws NoSuchAlgorithmException {

        AdminGen aGen = new AdminGen();

        session.persist(admn);
        System.out.println("is added");
        transaction.commit();

    }


    // ADD ADMIN IN CENTER  BY ADMINGeneral
    public  Center addAdminCenter(){

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session  = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();

        Center c = new Center();
        c.setVille("casablanca");
        c.setAdmin(admin);
        session.persist(c);
        transaction.commit();
        session.close();
        sessionFactory.close();
        return c;
    }


    //getCenterAdmins
public List getAdmins(){


    List<Admin> admins = (List<Admin>) session.createQuery("From Admin").list();
    //List<Object[]> adminsO = session.createSQLQuery("SELECT * from center INNER JOIN admin in center.admin_id = admin.id").list();
    transaction.commit();
    //lambda
    admins.forEach((a) -> {
        System.out.println("admin email : "+a.getId());
    });
    return admins;

}


public void editCenterAdmin(int idAdmin){

    transaction =session.beginTransaction();
        Admin admin = null;
        transaction = session.beginTransaction();
        admin = session.get(Admin.class, idAdmin);
        transaction.commit();
}
public void updateCenterAdmin(Admin admin){

      session.saveOrUpdate(admin);
    transaction.commit();

}


public boolean deleteCenterAdmin(int idAdmin){

        Admin admin = session.get(Admin.class , idAdmin);
        if(admin == null) {
            session.delete(admin);
            transaction.commit();
            return true;
        }

        return false;

}

    public boolean validate(String email, String password) {

        Admin admin1 = null;
        AdminGen adminGen = null;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            admin1 = (Admin) session.createQuery("FROM Admin a WHERE a.email = :email and a.password= :password")
                    .setParameter("email", email).setParameter("password",password)
                    .uniqueResult();
            adminGen = (AdminGen) session.createQuery("FROM AdminGen ag WHERE ag.email = :email and ag.password= :password")
                    .setParameter("email", email).setParameter("password",password)
                    .uniqueResult();

            if (admin1 != null && admin1.getPassword().equals(password) && admin1.getEmail().equalsIgnoreCase(email)) {
                System.out.println("you're logged as Center Admin");
                return true;
            }

            if (adminGen != null && adminGen.getPassword().equals(password) && adminGen.getEmail().equalsIgnoreCase(email)) {
            System.out.println("you're logged as General Admin");
            return true;
            }

            // commit transaction
            transaction.commit();

        return false;
    }


    }




