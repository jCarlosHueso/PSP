package cosa.de.Gillermo;

import java.io.PrintWriter;
import java.util.Scanner;

public class Escritor extends Thread {

	private Cliente c;
	private PrintWriter output;
	private Scanner t;

	public Escritor(PrintWriter output, Cliente c) {
		this.output = output;
		this.c = c;
		t = new Scanner(System.in);
	}

	public Cliente getCliente() {
		return this.c;
	}

	@Override
	public void run() {
		// VA A ESPERAR CONSTANTEMENTE A QUE EL USUARIO ENTRE UN TEXTO
		while (true) {

			try {

				String mensaje = t.nextLine();

				output.println(this.getCliente().getNick() + ": " + mensaje);

				if (mensaje.equalsIgnoreCase("salir")) {
					this.getCliente().salir();
				}

			} catch (Exception ex) {
				System.exit(0);
			}
		}
	}

}
