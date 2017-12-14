package commonMethodsimpl.java;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;    
 
    public class sendEmailimpl extends GeneralMethodsimpl{

    	@Override
    	public void email(){ 
    		//"from","password","to","sub","msg"
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.office365.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "587");   
          
          //get Session   
          Session session = Session.getInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("Annu.Singh@chevinfleet.com","Comput3r");  
           }    
          });    
          //compose message    
          try {   
           MimeMessage message = new MimeMessage(session); 
           message.setText("results is published");
           Multipart multipart = new MimeMultipart();
           //String file1 = "file:///C:/Users/annus/Desktop/Best%20Practices/QaEssentialsTestNG/test-output/emailable-report.html#m0";
           String file1 = "C:\\Users\\annus\\Desktop\\Best Practices\\QaEssentialsTestNG\\test-output\\emailable-report.html"; //change to your attachment filepath
           String fileName1 = "emailable-report.html"; //change to your attachment filename
           DataSource source1 = new FileDataSource(file1);
           message.setDataHandler(new DataHandler(source1));
           message.setFileName(fileName1);
           message.addRecipient(Message.RecipientType.TO,new InternetAddress("Annu.Singh@chevinfleet.com")); 
          // message.addRecipients(Message.RecipientType.CC, "laura.patterson@chevinfleet.com");
           message.setFrom("Annu.Singh@chevinfleet.com");
           message.setSubject("Test Run Results");    
         //  message.setText("Updates on FW Core Automation run");    
           
          // message.setContent(multipart);
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  

  
