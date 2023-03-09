package trabajo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class Servidor {
    private static int puerto=8888;
    private static ServerSocket serverSocket;
    private static Socket clienteSocket;
    static BufferedReader entrada =null;
    static PrintWriter salida = null;
    
    
    static Email mail = new Email();
	static UsoProperties usoProperties = new UsoProperties();
	static Scanner t = new Scanner(System.in);

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
        		entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                salida = new PrintWriter(clienteSocket.getOutputStream(), true);

                 String opcion=entrada.readLine();
                 do {
                     salida.println("Introduce opción:");
                     salida.println("0-Salir");
                     salida.println("1-Loguear");
                     salida.println("2-Registrarse");
                     

                     switch (opcion) {
                         case "fin":
                             salida.println("Hasta pronto");
                             break;
                         case "login":
                             login(entrada, salida);
                             break;
                         case "register":
                             register(entrada, salida);
                             break;
                         default:
                             salida.println("Opción no válida");
                             break;
                     }
                 } while (!opcion.equalsIgnoreCase("fin"));

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
     
     private static void register(BufferedReader entrada, PrintWriter salida) throws IOException {
         User u = new User();
         salida.println("Introduce tu nombre de usuario:");
         u.setName(entrada.readLine());
         salida.println("Introduce tu email:");
         u.setEmail(entrada.readLine());
         salida.println("Introduce tu contraseña:");
         String pwd = entrada.readLine();
         salida.println("Introduce otra vez tu contraseña:");
         String pwd2 = entrada.readLine();

         if (pwd.equalsIgnoreCase(pwd2)) {
             salida.println("Contraseña correcta");

             try {
                 String contraC = Cifrar.cifrarContra(pwd);
                 u.setPassword(contraC);

                 mail.enviarConGMail(u);

                 usoProperties.guardarUsuario(u);

                 salida.println("Usuario registrado correctamente");

             } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                 salida.println("Error al registrar el usuario: " + e.getMessage());
             }

         } else {
             salida.println("Error, las contraseñas no coinciden");
         }
     }

     private static void login(BufferedReader entrada, PrintWriter salida) throws IOException {
         User u = new User();
         salida.println("Introduce tu nombre de usuario:");
         u.setName(entrada.readLine());
         salida.println("Introduce tu contraseña:");
         u.setPassword(entrada.readLine());

//         boolean loginCorrecto = usoProperties.validarUsuario(u);
//
//         if (loginCorrecto) {
//             salida.println("Inicio de sesión correcto");
//         } else {
//             salida.println("Nombre de usuario o contraseña incorrectos");
//         }
     }


}
             
 

