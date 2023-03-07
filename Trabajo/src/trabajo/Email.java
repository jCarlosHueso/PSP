package trabajo;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	
public void enviarConGMail(User user) {
	    
	String host = "smtp.gmail.com";
    String username = "josecarlosclaseprueba@gmail.com";
    String password = "xphomdudvhrqzjog";

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
    try {
		message.setFrom(new InternetAddress("josecarlosclaseprueba@gmail.com"));
		
		
		
		
		 message.setRecipients(Message.RecipientType.TO,
			       InternetAddress.parse(user.getEmail()));
			    message.setSubject("Hola, "
						+user.getName());
			    message.setText( "\nSu cuenta ha sido registrada con exito"+
						"\nSu contraseña ha sido cifrada, aunque usted deberá seguir accediendo con su contraseña "
								+ "de siempre\n\n\nSu contraseña cifrada es:\n"+user.getPassword() );
			    // Enviar el mensaje
			    Transport.send(message);
			    
			    System.out.println("Email enviado con �xito.");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
 
}
}

