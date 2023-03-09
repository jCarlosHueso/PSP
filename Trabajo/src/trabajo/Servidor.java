package trabajo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private static int puerto=8888;
    private static ServerSocket serverSocket;
    private static Socket clienteSocket;


    public static void main(String[] args) {
    	 try {
             serverSocket = new ServerSocket(puerto);
             System.out.println("Servidor escuchando en el puerto " + puerto);

             while (true) {
                 Socket clienteSocket = serverSocket.accept();
                 System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress().getHostName());
                 Thread hiloCliente = new Thread(new ManejadorCliente(clienteSocket));
                 hiloCliente.start();
             }

         } catch (IOException e) {
             System.err.println("Error al iniciar el servidor: " + e.getMessage());
         }
     }

     public void cerrar() {
         try {
             serverSocket.close();
             System.out.println("Servidor desconectado");
         } catch (IOException e) {
             System.err.println("Error al cerrar el servidor: " + e.getMessage());
         }
     }

     private static class ManejadorCliente implements Runnable {
         private Socket clienteSocket;

         public ManejadorCliente(Socket clienteSocket) {
             this.clienteSocket = clienteSocket;
         }

         public void run() {
             try {
                 BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                 PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

                 String mensaje;
                 do {
                     mensaje = entrada.readLine();
                     System.out.println("Mensaje recibido: " + mensaje);
                     salida.println("Respuesta a " + mensaje);
                 } while (!mensaje.equals("fin"));

             } catch (IOException e) {
                 System.err.println("Error al manejar el cliente: " + e.getMessage());
             } finally {
                 try {
                     clienteSocket.close();
                     System.out.println("Cliente desconectado");
                 } catch (IOException e) {
                     System.err.println("Error al cerrar la conexión con el cliente: " + e.getMessage());
                 }
             }
         }
     }
 }

