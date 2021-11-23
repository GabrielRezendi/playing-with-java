package pc_monitor;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Alert {
    public void sendEmail() {
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.socketFactory.port", 2525);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.port", 2525);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("82ccabac8c5211", "6d1725be676168'");
            }
        });

        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
            message.setSubject("Mail Subject");
    
            String msg = "This is my first email using JavaMailer";
    
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
    
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
    
            message.setContent(multipart);
    
            Transport.send(message);
        } catch (Exception e) {
            //TODO: handle exception
        }
      
    }
}
