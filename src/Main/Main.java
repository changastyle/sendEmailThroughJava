package Main;

import controlador.JSONWS;

public class Main
{
    public static void main(String[] args)
    {
        String miUsuario = "barivendeofficial@gmail.com";
        String password = "Harvinahh4";
        String destinatario = "nico.grossi4@gmail.com";
        String asunto = "Tienes una Venta para Pulseras";
        String mensaje = "<a href=\"http://localhost:8080/barivende/pages/nuevoDetallePub/detallePublicacion.jsp?id=31\"> Venta </a>";
        
        String urlHtmlMail = "http://www.barivende.com:8081/upload/barivende/politicaPrivacidad/mail/mail-notificacion-venta.html?idPub=1&vendedorID=48&tituloPub=Fiat";
        //String html = JSONWS.getDataFromWS(urlHtmlMail);
        
        String banner = "Validacion de email";
        String urlRedireccionamiento = "www.google.com.ar";
        String html = StringEmail.dameHTMLParaElMail(banner, "Validar" ,urlRedireccionamiento);
        
        try
        {
            controller.Controller.sendEmail(miUsuario,"Barivende.com", password, destinatario, asunto, html);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
