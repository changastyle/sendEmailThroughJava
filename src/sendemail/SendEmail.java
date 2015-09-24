package sendemail;
public class SendEmail
{
    public static void main(String[] args)
    {
        String miUsuario = "ngrossi@tecnoaccion.com.ar";
        String password = "PASSWORD SUPER SECRETA QUE OBVIAMENTE NO VOY A DEVELAR :D ";
        String destinatario = "nico.grossi4@gmail.com";
        String asunto = "Testing Java Mail Library";
        String mensaje = "Este es el body de un email de pruebas enviado desde un servidor muy lejano";
        
        controller.Controller.sendEmail(miUsuario, password, destinatario, asunto, mensaje);
    }
    
}
