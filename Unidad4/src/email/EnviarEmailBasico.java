package email;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*Este ejemplo configura un MimeMessage usando la API de JavaMail
 *y lo env�a a trav�s de una cuenta de Gmail usando la autenticaci�n SMTP. 
 *El mensaje de correo electr�nico contiene un asunto, 
 *un destinatario y contenido de texto*/

public class EnviarEmailBasico {
   public static void main(String[] args) throws Exception {
      // Establecer las propiedades del email
//      String host = "smtp.gmail.com";
//      String username = "josecarlosclaseprueba@gmail.com";
//      String password = "xphomdudvhrqzjog";

      // Crear una sesi�n
      Properties props = new Properties();
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2");
      Session session = Session.getInstance(props, new Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      // Crear el mensaje
      /*
       * Un MimeMessage es una subclase de javax.mail.Message que representa 
       * un mensaje de correo electr�nico utilizando el formato MIME (Multipurpose Internet Mail Extensions). 
       * La clase MimeMessage proporciona m�todos para configurar y 
       * recuperar varios atributos de mensajes de correo electr�nico, 
       * como el remitente, el destinatario, el asunto, el contenido y los archivos adjuntos.*/
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("josecarlosclaseprueba@gmail.com"));
      message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse("jchuesos01@educarex.es"));
      message.setSubject("Prueba PSP");
      message.setText("PruebaPruebaPrueba");

      // Enviar el mensaje
      Transport.send(message);
      System.out.println("Email enviado con �xito.");
   }
}
