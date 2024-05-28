package com.jci.service.Impl;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {

	
	/*
	 * public static void main(String args[]) { try { InternetAddress[] toAddresses
	 * = {new InternetAddress("animesh.anand@cyfuture.com") ,new
	 * InternetAddress("vishal.vishwakarma@cyfuture.com"), new
	 * InternetAddress("animesh.anand@cyfuture.com")};
	 * 
	 * 
	 * sendEmail(toAddresses,"hi","Hello","Animesh","Jute Corporation of India");
	 * }catch (Exception e) { } }
	 */
	  
	 

	public void sendEmail(InternetAddress[] toAddresses, String body, String subject, String filename,
			String username1) {
       // System.out.println("send mail data = "+body+subject+filename+username1);
		String smtpHost = "smtp.gmail.com";
		int smtpPort = 587; // Use 587 for TLS or 465 for SSL
		// String username = "jci.sahyog@jcimail.in"; // Office 365 email address
		// String password = "Patsan@2024";
		String username = "jci.erp@jcimail.in"; // Office 365 email address
		String password = "Patsan@2024";
		// String recipient = "vishal.vishwakarma@cyfuture.com"; // Recipient's email
		// address

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort);
	    props.put("mail.smtp.ssl.protocols","TLSv1.2");	

		Session session = Session.getInstance(props);

		try {

			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, toAddresses);
			message.setFrom(new InternetAddress(username));
			message.setSubject(subject);
			message.setText(body);

			
			 BodyPart messageBodyPart = new MimeBodyPart(); messageBodyPart.setText(body);
			 
			 
			 Multipart multipart = new MimeMultipart();
			 multipart.addBodyPart(messageBodyPart);
			 
			 messageBodyPart = new MimeBodyPart();
			 
			 DataSource source = new FileDataSource(filename);
			 messageBodyPart.setDataHandler(new DataHandler(source));
			 messageBodyPart.setFileName(username1);
			 multipart.addBodyPart(messageBodyPart); message.setContent(multipart);
			
			 
			Transport transport = session.getTransport("smtp");
			transport.connect(smtpHost, smtpPort, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			System.out.println("Sent message successfully....");

		} catch (Exception e) {
			System.out.println("error in sending mail" + e);
			e.printStackTrace();
		}

	}

}
