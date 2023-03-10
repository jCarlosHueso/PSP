package unidad3.ejemplos.ejemplo6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class DescargadorHTML {

	public static void main(String[] args) {
		//Parámetros de conexión
		int puerto=80;
		String direccion="www.google.es";
		
		//Inicialización
		Socket socket;
		InetSocketAddress direccionRed;
		direccionRed=new InetSocketAddress(
				direccion, puerto);
		socket=new Socket();
		try {
			socket.connect(direccionRed);
			OutputStream os;
			InputStream is;
			os=socket.getOutputStream();
			is=socket.getInputStream();
			
			
			InputStreamReader isr;
			isr=new InputStreamReader(is);
			
			OutputStreamWriter osw;
			osw=new OutputStreamWriter(os);
			
			BufferedReader bfr;
			bfr=new BufferedReader(isr);
			
			PrintWriter pw;
			pw=new PrintWriter (osw);
			
			pw.println("GET /index.html");
			pw.flush();
			
			String linea;
			while ( (linea=bfr.readLine())!=null){
				System.out.println(linea);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
