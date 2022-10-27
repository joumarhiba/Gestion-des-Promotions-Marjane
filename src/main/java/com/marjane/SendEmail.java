package com.marjane;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import static javax.mail.Transport.*;

public class SendEmail {

   /* public String emailSender(String recipient) {
        String uniqueID = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");


        String accountMail = "zak.tajer@gmail.com";
        String password = "tofgspijddplvuzo";


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountMail, password);
            }
        });
        Message message = prepareMessage(session, accountMail, recipient, uniqueID);
        try {
            if (message != null) {
                send(message);
            }else  {
                System.out.println("Error happened while sending message");
            }
            System.out.println("Message sent");

            return uniqueID;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private Message prepareMessage(Session session, String accountMail, String recipient, String uniqueID) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(accountMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Test java email");
            message.setText("your verification password is is:" + "" + uniqueID);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    } */

    public String a = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    public void go(String toEmail) throws MessagingException, IOException {
        //authentication info


        final String username = "hhiba5568@gmail.com";
        final String password = "przgzyucdaewsnzy";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");

        javax.mail.Session session = javax.mail.Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        //Start our mail message
        Message message = null;

        message = prepareMessage(session, username,toEmail);
        Transport.send(message);

    }

    private static Message prepareMessage(Session session, String username, String toEmail) throws MessagingException, MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("Your new Password");

        message.setText("voici votre password : hhhhhhhhhhhhhhhhhhhhhhhhhhh" );

        return  message;
    }

}
