package cosa.de.Gillermo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputFilter.Status;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente extends Thread {

	private String nick;
	private Socket socket;
	private BufferedReader input;
	private Lector lector;
	private PrintWriter output;
	private Escritor escritor;
	private static final int PUERTO = 8080;

	public Cliente(InetAddress addr, String nick) {
		this.nick = nick;
		
		try {

			socket = new Socket(addr, Cliente.PUERTO);

			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			lector = new Lector(input, nick);
			
			output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			escritor = new Escritor(output, this);
			
			

		} catch (IOException e) {
			System.err.println("El socket ha fallado");
			try {
				socket.close();
			} catch (IOException e2) {
				System.err.println("Socket not closed");
			}
		}
	}
	
	public static void main(String [] args) {
		try {
			Scanner t = new Scanner(System.in);
			System.out.print("ELIJA SU NOMBRE DE USUARIO: ");
			String user = t.nextLine();
			
			System.out.println("\nVA A ENTRAR EN EL CHAT. PARA SALIR -> ESCRIBA LA PALABRA \"salir\"\n");
			
			(new Cliente(InetAddress.getByName("192.168.2.33"), user)).start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		lector.start();
		escritor.start();
	}
	
	public String getNick() {
		return this.nick;
	}
	
	public Socket getSocket() {
		return this.socket;
	}
	
	@SuppressWarnings("deprecation")
	public void salir() {
			System.out.println("\nSALI� DEL CHAT");
			this.stop();
			System.exit(0);
	}
	
}
