package trabajo;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;
import java.util.Scanner;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Main {
	static Scanner t = new Scanner(System.in);
	static Email mail = new Email();
	static UsoProperties usoProperties = new UsoProperties();
	public static void main(String[] args) {

		
		int option;
		do {
			System.out.println("Introduce opción:");
			System.out.println("0-Salir");
			System.out.println("1-Loguear");
			System.out.println("2-Registrarse");
			option = t.nextInt();
			t.nextLine();
			switch (option) {
			case 0:
				System.out.println("hasta pronto");
				break;
			case 1:
				login();
				break;
			case 2:
				Register();
				break;
			
			}
		} while (option != 0);
	}
	
	private static void Register() {
		User u = new User();
		System.out.println("introduce tu nombre de usuario:");
		u.setName(t.nextLine());
		System.out.println("introduce tu email:");
		u.setEmail(t.nextLine());
		System.out.println("introduce tu contraseña:");
		String pwd=t.nextLine();
		System.out.println("introduce otra vez tu contraseña:");
		String pwd2=t.nextLine();
		if(pwd.equalsIgnoreCase(pwd2)) {
			
			System.out.println("contra correcta");
			// aqui ya tengo un usuario con  el nombre y el email, y la contra sin cifrar
			// cifrar la contra y meterla en un .properties
			try {
				String contraC = Cifrar.cifrarContra(pwd);
				u.setPassword(contraC);
				
				//avisar con mail
				mail.enviarConGMail(u);
				//meter en el properties
				
				
				usoProperties.guardarUsuario(u);
				
				
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			System.out.println("Error, las contraseñas no coinciden");
		}
		
	}
	
	


	private static void login() {
		User u = new User();
		System.out.println("introduce tu nombre de usuario:");
		u.setName(t.nextLine());
		System.out.println("introduce tu contraaseña:");
		u.setPassword(t.nextLine());
		
		
		
	}
		
	}


