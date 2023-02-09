package trivial;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPreguntas {

	AccesoDatos ad = new AccesoDatos();
	
	public static void main(String[] args) throws IOException {

		ServidorPreguntas servidor = new ServidorPreguntas();

		servidor.escuchar();
	}

	public String obtenerPregunta(String cat) {
		String resultado = "default text";
		
		ad.obtenerPregunta(cat);
		
		return resultado;
		
	}

	public void escuchar() throws IOException {
		System.out.println("Arrancado el servidor");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9876);
		} catch (IOException e) {
			System.out.println("No se pudo poner un socket a escuchar en TCP 9876");
			return;
		}
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.out.println("Conexion recibida!");
			InputStream is = conexion.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			String cat = bf.readLine();
			OutputStream os = conexion.getOutputStream();
			PrintWriter pw = new PrintWriter(os);

			obtenerPregunta(cat);
			pw.flush();
		}
	}
}