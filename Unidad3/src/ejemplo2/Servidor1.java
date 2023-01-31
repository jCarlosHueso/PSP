package ejemplo2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.DataOutputStream;

public class Servidor1 {

	public static void main(String[] args) throws IOException {
		
		int numeroPuerto=6000;
		ServerSocket servidor=null;
		
		servidor = new ServerSocket(numeroPuerto);
		
  		
		/*getLocalPort() devuelve el puerto local al que est� enlazado el ServerSocket*/
		System.out.println("Escuchando en "+ servidor.getLocalPort());
		
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente...");
		
		/*
		 * El m�todo accept() escucha una solicitud de conexi�n de un cliente y la acepta cuando
		 * se recibe. Una vez que se ha establecido la conexi�n con el cliente, devuelve un objeto 
		 * de tipo Socket, a trav�s del cual se establecer� la comunicaci�n con el cliente. 
		 * Tras esto, el ServerSocket sigue disponible para realizar nuevos accept(). Puede lanzar
		 * IOException.*/
		clienteConectado = servidor.accept();
		
		//CREAMOS UN FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = null;
		
		entrada = clienteConectado.getInputStream();
		/*Si queremos enviar o recibir tipos normales (enteros, flotantes, strings) 
		 * tenemos las clases DataInputStream y DataOutputStream. 
		 * Estas clases tienen un constructor que admite un InputStream 
		 * y un OutputStream respectivamente.*/
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		//EL CLIENTE ME ENV�A UN MENSAJE
		System.out.println("Recibiendo del CLIENTE:\n\t"+ flujoEntrada.readUTF());
		
		//CREAR UN FLUJO DE SALIDA AL CLIENTE.
		OutputStream salida=null;
		salida=clienteConectado.getOutputStream();
		
		DataOutputStream flujoSalida= new DataOutputStream(salida);
		
		//ENVIO UN SALUDO AL CLIENTE
		flujoSalida.writeUTF("Saludos al cliente del servidor");
		/* Para strings usaremos los m�todos writeUTF() y readUTF(
		 * que env�an/leen las cadenas en formato UTF - Unicode Transformation Format*/
		
		//CERRAR STREAMS Y SOCKETS 
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoEntrada.close();
		clienteConectado.close();
		servidor.close();
		
		
	}
	
}
