package com.mail.java;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class newww {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("isharaathukorala@gmail.com","sudubabi2459358");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("isharaathukorala@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("sendanayaka1992@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");
			
			
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		    
		    String filename = "C:\\Users\\Ishara\\Desktop\\1.txt";//change accordingly  
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}