package ejemplo6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class EjemploURLCon {

	public static void main(String[] args) {
		
		URL url=null;
		URLConnection urlCon=null;
		
		try {
			url = new URL("http://hueso.atwebpages.com/obteneranio/comprobarMayorEdad.php");
			//url = new URL("http://192.168.2.14/psp/comprobarMayorEdad.php");
			urlCon=url.openConnection();
			//Permite que el usuario env�e datos si el par�metro es true. Por defecto = true.
			urlCon.setDoOutput(true);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("introduce el primer numero");
			int x=sc.nextInt();sc.nextLine();
			System.out.println("introduce el segundo numero");
			int y=sc.nextInt();sc.nextLine();
			String cadena="n1="+x+"&n2="+y;
			//ESCRIBIR LA URL CON LOS PAR�METROS
			PrintWriter salida= new PrintWriter(urlCon.getOutputStream());
			salida.write(cadena);
			salida.close(); //cerrar el flujo
			
			BufferedReader in;
			InputStream entrada = urlCon.getInputStream();
			in = new BufferedReader(new InputStreamReader(entrada));
			
			String linea;
			while((linea=in.readLine())!=null) {
				System.out.println(linea);
			}
			
			in.close();
			
		}
		catch(MalformedURLException e) {
			System.err.println("URL mal formada:"+e);
		}
		catch(IOException e) {
			System.err.println("Error IO"+ e);
		}

	}

}
