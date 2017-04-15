package com.overture.npc.methods;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;

import java.util.Date;
import java.util.Properties;

public class Emailer {

    private static final String SMTP_HOST_NAME = "smtp.sendgrid.net";
    private static final String SMTP_AUTH_USER = "overture_email";
    private static final String SMTP_AUTH_PWD  = "C0nduct0r!";

     public static void sendMail(String basepath, boolean sendMailIndicator,String cc, String attachFilename, String browser, String environment, String environmentName){
    	Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        String to="pravin@overturecorp.com";
        try{
        if(sendMailIndicator){
		    System.out.println("Send Mail Initiated for the following recipients;");
		    System.out.println(" TO : ["+to+"]");
		    System.out.println(" CC : ");
		    String [] ccList = cc.split(";");
		    for (int i=0;i<ccList.length;i++){
		    	System.out.println("   : "+" "+i+" "+ccList[i]);
		    }
        
        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getInstance(props, auth);
       
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);

        Multipart multipart = new MimeMultipart("alternative");

        BodyPart part1 = new MimeBodyPart();
        //part1.setText("Hi, \n\nBelow is the Execution Summary.\n\nBROWSER  ::  "+browser+"."+"\n\nENVIRONMENT NAME  ::  "+environmentName+"."+"\n\nENVIRONMENT  ::  "+environment+"."+"\n\nFor further details regarding passed and failed cases, please see the HTML report attached.\n\nThis is an auto-generated Selenium Test Case Execution Results Email.\n Please Do not reply.\n\nRegards,\n\nSelenium Test Executer.");
        part1.setContent("Hi,<br><br>Below is the Execution Summary.<br><br><b>BROWSER  ::  </b>"+browser+"."+"<br><b>ENVIRONMENT NAME  ::  </b>"+environmentName+"."+"<br><b>ENVIRONMENT  ::  </b>"+environment+"."+"<br><br>For further details regarding passed and failed cases, please see the HTML report attached.<br><br>This is an auto-generated Selenium Test Case Execution Results Email.<br>Please Do not reply.<br><br>Regards,<br>Selenium Test Executer.","text/html");
        multipart.addBodyPart(part1);
     
       BodyPart attachmentBodyPart = new MimeBodyPart();
       DataSource source = new FileDataSource(basepath+"/test-output/"+browser+"/"+attachFilename);
	    
	   attachmentBodyPart.setDataHandler(new DataHandler(source));
	   attachmentBodyPart.setFileName(browser+"_"+attachFilename);
	   multipart.addBodyPart(attachmentBodyPart);
       
       message.setContent(multipart);
       message.setFrom(new InternetAddress(to));
       message.setSubject("Selenium Test Case Execution Results!  "+ new Date());
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

        String [] cclist = cc.split(";");
	    for (int i=0;i<cclist.length;i++){
	    	message.addRecipient(Message.RecipientType.CC,new InternetAddress(cclist[i]));
	    }
        transport.connect();
        transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
        transport.sendMessage(message,message.getRecipients(Message.RecipientType.CC));
        transport.close();
    }
    }catch (Exception e) {
    	System.out.println("Failure in Sending Mail ....  :( ");
		System.out.println(e.getClass());
	}
       
    }

    private static class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
           String username = SMTP_AUTH_USER;
           String password = SMTP_AUTH_PWD;
           return new PasswordAuthentication(username, password);
        }
    }
}