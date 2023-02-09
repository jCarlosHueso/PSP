package trivial;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientePreguntas {
	public static BufferedReader getFlujo(InputStream is) {
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		return bfr;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
		Socket socket = new Socket();
		socket.connect(direccion);
		BufferedReader bfr = ClientePreguntas.getFlujo(socket.getInputStream());
		PrintWriter pw = new PrintWriter(socket.getOutputStream());

		Scanner s = new Scanner(System.in);

		System.out.println("Introduce la categoria de la pregunta");
		String x = s.nextLine();

		pw.println(x);

		pw.flush();

		String resultado = bfr.readLine();
		System.out.println(resultado);
	}
}