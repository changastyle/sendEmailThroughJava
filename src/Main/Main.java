package Main;

import controlador.JSONWS;
import java.util.ArrayList;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // 1 - LEER EL ARCHIVO HTML PARA PODER PONER LOS VALORES QUE YO QUIERO:
        String urlArchivoHtmlTemplate = "C:\\Users\\ngrossi\\Desktop\\prueba.html";
        
        // 2 - LISTADO DE VALORES A REEMPLAZAR EN EL HTML A ENVIAR:
        List<Parametro> parametrosList = new ArrayList<>();
        parametrosList.add(new Parametro("titulo", "TITI"));
        parametrosList.add(new Parametro("mierda", "olorossa"));
        parametrosList.add(new Parametro("subtitulo", "SUBTITI"));
        parametrosList.add(new Parametro("enlace", "www.google.com.ar"));
        parametrosList.add(new Parametro("visualizacionEnlace", "Ir a google"));
        parametrosList.add(new Parametro("imagen", "https://www.aciprensa.com/imagespp/Catedral-Primada-Mexico-Francisco-Diez-Wikipedia-090718.jpg"));
        
        // 3 - CONVERTIME EL ARCHIVO HTML CON ETIQUETAS ANGULAR CON LOS VALORES QUE YO NECESITO:
        List<String> arrHtmlConvertido = HtmlParserForMails.testHTMLAutocompletar(urlArchivoHtmlTemplate, parametrosList);
        String htmlFinal = HtmlParserForMails.dameHtmlAsStringFromList(arrHtmlConvertido);
        
        
        
        // 4 - DATOS PARA PODER ENVIAR EL CORREO:
        String remitente = "barivendeofficial@gmail.com";
        String passwordRemitente = "Harvinahh4";
        String destinatario = "nico.grossi4@gmail.com";
        String asunto = "Tienes una Venta para Pulseras";
        
        try
        {
            controller.Controller.sendEmail(remitente,"Barivende.com", passwordRemitente, destinatario, asunto, htmlFinal);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
