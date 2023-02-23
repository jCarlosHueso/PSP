package email;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class EnviarEmailAdjuntoBasico {
   public static void main(String[] args) throws Exception {
      // Propiedades del email
//      String host = "smtp.gmail.com";
//      String username = "josecarlosclaseprueba@gmail.com";
//      String password = "xphomdudvhrqzjog";

      // Crear la sesi�n
      Properties props = new Properties();
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2");
      Session sesion = Session.getInstance(props, new Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      // Crear mensaje con adjunto
      Message mensaje = new MimeMessage(sesion);
      mensaje.setFrom(new InternetAddress("josecarlosclaseprueba@gmail.com"));
      mensaje.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse("jchuesos01@educarex.es"));
      mensaje.setSubject("Aviso de curso");

      // Crear el cuerpo del mensaje
      /*En Java, MimeBodyPart es una clase que representa una sola parte de un objeto MimeMultipart, 
       * que se utiliza para enviar y recibir mensajes de correo electr�nico en formato 
       * MIME (Multipurpose Internet Mail Extensions). Un MimeBodyPart puede contener cualquier 
       * tipo de datos, como texto sin formato, HTML, im�genes, audio, video u otros archivos adjuntos.
       */
      MimeBodyPart cuerpoMensaje = new MimeBodyPart();
      String textoMensaje = "Este email contiene como adjunto la informaci�n del curso.";
      cuerpoMensaje.setText(textoMensaje);

      // Crear el adjunto
      MimeBodyPart adjunto = new MimeBodyPart();
      String contenidoAdjunto = "prueba adjuntar txt";
      InputStream adjuntoStream = new ByteArrayInputStream(
         contenidoAdjunto.getBytes(StandardCharsets.UTF_8));
      DataSource fuente = new ByteArrayDataSource(adjuntoStream, "text/plain");
      adjunto.setDataHandler(new DataHandler(fuente));
      adjunto.setFileName("txtAdjunto.txt");

      // Crear el mensaje multipart y a�adir el mensaje y el adjunto
      MimeMultipart multipart = new MimeMultipart();
      multipart.addBodyPart(cuerpoMensaje);
      multipart.addBodyPart(adjunto);
      mensaje.setContent(multipart);

      // Enviar el mensaje
      Transport.send(mensaje);
      System.out.println("Email enviado con �xito.");
   }
}
