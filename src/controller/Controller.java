package controller;

import java.io.File;
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
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Controller
{
    public static void sendEmail(String usuario, String alias , String password, String destinatario, String asunto , String mensaje)
    {
        
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
 
        Session session = Session.getInstance(props,new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(usuario, password);
            }
        });
 
        try 
        {
 
            MimeMessage message = new MimeMessage(session);
            message.setContent(mensaje, "text/html; charset=utf-8");
            message.setFrom(new InternetAddress(usuario, alias));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            
            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachPart = new MimeBodyPart();
            //String urlHtmlMail = "http://www.barivende.com:8081/upload/barivende/politicaPrivacidad/mail/mail-notificacion-venta.html?idPub=1&vendedorID=48&tituloPub=Fiat";

            //message.setText(mensaje);
 
            Transport.send(message);
            System.out.println("Email enviado con exito!");
 
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
