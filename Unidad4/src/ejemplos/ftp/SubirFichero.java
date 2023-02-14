package ejemplos.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class SubirFichero {

	public static void main(String[] args) throws IOException {
		
		FTPClient cliente = new FTPClient();
		
		String servFTP= "f27-preview.runhosting.com";
		
		System.out.println("Nos conectamos a: "+servFTP);

//		String usuario = "4258683";
//		String clave = "admin.1234";
	
		String usuario = "4250144_nombre";
		String clave = "contra1ftp";
		
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
		
		/* ############################################# */
		 
		String direc="datos_DB";
		
		cliente.changeWorkingDirectory(direc);
		
        cliente.setFileType(FTP.BINARY_FILE_TYPE);
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("/home/mint/Escritorio/Datos.txt"));
		
		cliente.storeFile("Datos_DB.txt", in);
		
		/* ############################################# */
		
		in.close();
		
		
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
