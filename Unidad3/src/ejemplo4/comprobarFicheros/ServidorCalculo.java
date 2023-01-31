package ejemplo4.comprobarFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculo {

	public static void main(String[] args) throws IOException {

		ServidorCalculo servidor = new ServidorCalculo();

		servidor.escuchar();
	}

	public boolean comprobarFichero(String op) {
		boolean resultado = false;
		
		File f = new File(op);
		
		System.out.println(op);
//		try {
//			f.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (f.exists()) {
			
			resultado = true;
			
			System.out.println("resultado=true");
			
		}
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
			String linea = bf.readLine();
			OutputStream os = conexion.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			if (this.comprobarFichero(linea)) {
				pw.write("el fichero existe\n");
			} else {
				pw.write("el fichero no existe\n");
			}
			pw.flush();
		}
	}
}