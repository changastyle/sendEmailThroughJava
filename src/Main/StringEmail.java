package Main;

public class StringEmail
{

    public static String dameHTMLParaElMail(String mensaje, String enlaceNombre , String enlaceURL)
    {
        String html = "";
        
        html = "<html>";
        html += "<head>";
        html += "</head>";
            html += "<body>";
                html += "<h3>" + mensaje + "</h3>";
                html += "<a href=\"" + enlaceURL +"\">" + enlaceNombre + "</a>";
            html += "</body>";
        html += "</html>";
        
        return html;
    }
}
