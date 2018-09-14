package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlParserForMails
{

    public static String dameHTMLParaElMail(String mensaje, String enlaceNombre , String enlaceURL)
    {
        String html = "";
        
        html = "<html>";
        html += "<head>";
        html += "</head>";
            html += "<body>";
                html += "<h3>" + mensaje + "</h3>";
                html += "<a href='" + enlaceURL + "'>" + enlaceNombre + "</a>";
            html += "</body>";
        html += "</html>";
        
        return html;
    }
    
    public static List<String> testHTMLAutocompletar(String urlArchivoConHtml , List<Parametro> parametrosList)
    {
        List<String> arrLineasConvertidas = new ArrayList<String>();
        List<String> arrLineasLeidas = readFile(urlArchivoConHtml);
        
        //System.out.println("lineas leidas: " +  arrLineasLeidas.size() );
        
        for(String s: arrLineasLeidas)
        {
            String lineaConvertida = completarValoresDeLaLinea(s,parametrosList);
            //System.out.println(lineaConvertida);
            
            arrLineasConvertidas.add(lineaConvertida);
            
        }
        
        return arrLineasConvertidas;
        
    }
    public static String completarValoresDeLaLinea(String lineaEntrada, List<Parametro> parametrosList)
    {
        String lineaSalida = "";
        
        boolean llaveAbierta1 = false;
        boolean llaveAbierta2 = false;
        boolean llaveCerrada1 = false;
        boolean llaveCerrada2 = false;
        int posApertura = -1;
        int posCierre = -1;
        
        for(int i = 0 ; i < lineaEntrada.length() ; i++)
        {
            char caracterActual = lineaEntrada.charAt(i);
            
            if(caracterActual == '{' && llaveAbierta1)
            {
                llaveAbierta1 = false;
                llaveAbierta2 = true;
                llaveCerrada1 = false;
                llaveCerrada2 = false;
                posApertura = i + 1 ;
            }
            else if(caracterActual == '{' && !llaveAbierta1)
            {
                llaveAbierta1 = true;
                llaveAbierta2 = false;
                llaveCerrada1 = false;
                llaveCerrada2 = false;
            }
            else if( caracterActual == '}' && llaveCerrada1 )
            {
                llaveAbierta1 = false;
                llaveAbierta2 = false;
                llaveCerrada1 = false;
                llaveCerrada2 = true;
            }
            else if( caracterActual == '}' && llaveAbierta2 )
            {
                llaveAbierta1 = false;
                llaveAbierta2 = false;
                llaveCerrada1 = true;
                llaveCerrada2 = false;
                posCierre = i;
            }
        }
        
        
        if(posApertura != -1 && posCierre != -1)
        {
            String valorCorrespondiente = "";
            String parametroEncontrado = lineaEntrada.substring(posApertura,posCierre);
            //System.out.println("parametroEncontrado : " + parametroEncontrado);
            
            for(Parametro parametroLoop : parametrosList)
            {
                String nombreParametro = parametroLoop.getNombre();
                
                if(nombreParametro.equalsIgnoreCase(parametroEncontrado))
                {
                    valorCorrespondiente = parametroLoop.getValor();
                    break;
                }
            }
            
            //ASIGNO LA NUEVA LINEA:
            lineaSalida += lineaEntrada.substring(0, (posApertura - 2) );
            lineaSalida += valorCorrespondiente;
            lineaSalida += lineaEntrada.substring( (posCierre + 2 ), lineaEntrada.length());
            
        }
        else
        {
            lineaSalida = lineaEntrada;
        }

        // RECURSIVIDAD SI QUEDO ALGO SIN CONVERTIR:
        if(lineaSalida.contains("{{"))
        {
            lineaSalida = completarValoresDeLaLinea(lineaSalida,parametrosList);
        }
        
        return lineaSalida;
    }
    
    
    
    public static List<String> readFile(String urlArchivo) 
    {
        List<String> arrLineas = new ArrayList<String>();
        
        File archi = new File(urlArchivo);
        
        try 
        {
            if(archi != null)
            {
                if(archi.exists())
                {
                    BufferedReader br = new BufferedReader(new FileReader(archi));
                    
                    String lineaLoop;

                    while ((lineaLoop = br.readLine()) != null)
                    {
                        arrLineas.add(lineaLoop);
                        //System.out.println(lineaLoop);
                    }
                }
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        return arrLineas;
    }
    
    public static String dameHtmlAsStringFromList(List<String> arrLineas)
    {
        String html = "";
        
        for(String sLoop : arrLineas)
        {
            html += sLoop;
        }
        
        return html;
    }
}
