package com.jci.service.Impl;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class sendemailBOS {

	 public void sendEmailBos(InternetAddress[] toAddresses, String body, String subject,String filePathDir, String username1)
     {

             String smtpHost = "smtp.gmail.com";
             int smtpPort = 587; // Use 587 for TLS or 465 for SSL
             String username = "shahkailash2000@gmail.com"; // Office 365 email address
             String password = "ckerjosrcwrxwzxq";
           
             
             
             Properties props = new Properties();
             props.put("mail.smtp.auth", "true");
             props.put("mail.smtp.starttls.enable", "true");
             props.put("mail.smtp.host", smtpHost);
             props.put("mail.smtp.port", smtpPort);
             props.put("mail.smtp.ssl.protocols","TLSv1.2");
          
                       Session session = Session.getInstance(props);
                    
                     try {
                                  Message message = new MimeMessage(session);
                                  message.setRecipients(Message.RecipientType.TO,toAddresses);
                                  message.setFrom(new InternetAddress(username));
                                  message.setSubject(subject);
                                  
              BodyPart messageBodyPart = new MimeBodyPart();
              messageBodyPart.setText(body);
              
              Multipart multipart = new MimeMultipart();
              multipart.addBodyPart(messageBodyPart);
              
              messageBodyPart = new MimeBodyPart();
              
              DataSource source = new FileDataSource(filePathDir);
              messageBodyPart.setDataHandler(new DataHandler(source));
              messageBodyPart.setFileName(username1);
              multipart.addBodyPart(messageBodyPart);
              message.setContent(multipart);
              Transport transport = session.getTransport("smtp");
              transport.connect(smtpHost, smtpPort, username, password);
              transport.sendMessage(message, message.getAllRecipients());
              transport.close();
              }catch(Exception e)
                 {
                    e.printStackTrace();
                 }
     
      }
}
