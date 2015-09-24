package controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Controller
{
    public static void sendEmail(String usuario , String password, String destinatario, String asunto , String mensaje)
    {
        Properties props = new Properties();
        /*props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");*/
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "10.10.20.10");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "10.10.20.10");
        
 
        Session session = Session.getInstance(props,new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(usuario, password);
            }
        });
 
        try 
        {
 
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);
 
            Transport.send(message);
            System.out.println("Email enviado con exito!");
 
        } 
        catch (MessagingException e) 
        {
            throw new RuntimeException(e);
        }
    }

}
