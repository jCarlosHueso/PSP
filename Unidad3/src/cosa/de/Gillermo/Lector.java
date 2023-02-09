package cosa.de.Gillermo;

import java.io.BufferedReader;
import java.io.IOException;

public class Lector extends Thread {

	private BufferedReader input;
	private String nick;

	public Lector(BufferedReader input, String nick) {
		this.input = input;
		this.nick = nick;
	}

	@Override
	public void run() {
		// VA A COMPROBAR CONSTANTEMENTE QUE EL SERVIDOR TENGA UNA SALIDA
		while (true) {

			try {

				String linea = input.readLine();

				if (!linea.startsWith(nick)) {
					System.out.println(linea);
				}

			} catch (IOException e) {
				System.exit(0);
			}
		}
	}

}
