package trabajo;

import java.util.Scanner;

public class Main {
	static Scanner t = new Scanner(System.in);
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
		System.out.println("introduce tu contraaseña:");
		String pwd=t.nextLine();
		System.out.println("introduce otra vez tu contraseña:");
		if(pwd==t.nextLine()) {
			u.setPassword(pwd);
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


