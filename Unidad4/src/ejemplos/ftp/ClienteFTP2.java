package ejemplos.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

// 						xphomdudvhrqzjog


public class ClienteFTP2 {

	public static void main(String[] args) throws IOException {
		
		FTPClient cliente = new FTPClient();
		
		String servFTP= "f27-preview.runhosting.com";
		
		System.out.println("Nos conectamos a: "+servFTP);

		String usuario = "4258683";
		String clave = "admin.1234";
		
		cliente.connect(servFTP);
		cliente.enterLocalPassiveMode();
		
		
		boolean login = cliente.login(usuario, clave);
		
		if(login) {
			System.out.println("Login correcto...");
		}else {
			
			System.out.println("Login incorrecto");
			cliente.disconnect();
			System.exit(1);
		}
		
		System.out.println("Directorio actual:"+cliente.printWorkingDirectory());
		
		FTPFile[] files = cliente.listFiles();
		
		System.out.println("Ficheros en el directorio actual:"+files.length);
		
		String tipos[] = {"Fichero","Directorio","Enlace simb."};
		
		for(int i = 0; i<files.length; i++) {
			System.out.println("\t"+files[i].getName()+"=>"+tipos[files[i].getType()]);
		}
		
		
		boolean logout = cliente.logout();
		if(logout) {
			System.out.println("Logout del servidor FTP...");
		}else {
			System.out.println("Error al hacer Logout...");
		}
		 
		cliente.disconnect();
		
		System.out.println("Conexi�n finalizada");
		

	}
	
	

}
