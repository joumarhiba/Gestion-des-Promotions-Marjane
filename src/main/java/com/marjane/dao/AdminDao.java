package com.marjane.dao;

import com.marjane.CryptPwd;
import com.marjane.SendEmail;
import com.marjane.entities.Admin;
import com.marjane.entities.AdminGen;
import com.marjane.entities.Center;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AdminDao {
    private EntityManager entityManager;
    static Session session;
    static Transaction transaction;
    static SessionFactory sessionFactory;

Admin admin = new Admin();
    public static void main(String[] args) throws NoSuchAlgorithmException, MessagingException, IOException {
        AdminDao ad = new AdminDao();
       ad.addAdmin();
       //ad.addAdminCenter();
       ad.getAdmins();
    }

    public void addAdmin() throws NoSuchAlgorithmException, MessagingException, IOException {


        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session  = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();


        AdminGen aGen = new AdminGen();
        SendEmail sendEmail = new SendEmail();

        aGen.setAdminId(1);
        aGen.setEmail("supAdmin@gmail.com");
        aGen.setPassword("12345678");
        admin.setEmail("joumhiba7@gmail.com");
        sendEmail.go(admin.getEmail());
        admin.setPassword(sendEmail.a);
        admin.setAdminGen(aGen);
        String pwd = admin.getPassword();
        CryptPwd cp = new CryptPwd();
        String hashedP = cp.cryptage(pwd);
        admin.setPassword(hashedP);
        session.persist(admin);
        System.out.println("is added");
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    // ADD ADMIN IN CENTER  BY ADMINGeneral
    public  Center addAdminCenter(){

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

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
public void getAdmins(){
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session  = sessionFactory.openSession();
    Transaction transaction =session.beginTransaction();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connect");
    EntityManager em = emf.createEntityManager();

    List<Admin> admins = session.createQuery("from Admin").list();
    List aList = session.createSQLQuery("SELECT * From admin").list();
    transaction.commit();
    session.close();
    sessionFactory.close();
    //lambda
    admins.forEach((item) -> {
        System.out.println("admin email : "+item.getEmail());
    });

}


    }














//    public AdminDao() {

        // Create Entity manager factory object
        //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connect");
        // Create Entity manager object
        //this.entityManager = entityManagerFactory.createEntityManager();


        /*final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        session  = sessionFactory.openSession();
        transaction =session.beginTransaction();
    }

    public void insert(Admin entity) throws Exception {

        this.entityManager.persist(entity);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }*/


