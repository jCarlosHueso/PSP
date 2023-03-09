package trabajo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private static String host="localhost";
    private static int puerto=8888;
    private static Socket socket;

 

    public static void main(String[] args) {
        try {
            socket = new Socket(host, puerto);
            System.out.println("Conexión establecida con el servidor");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            String mensaje;
            do {
                System.out.print("Introduzca mensaje ('fin' para terminar): ");
                mensaje = teclado.readLine();
                salida.println(mensaje);
                System.out.println("Respuesta del servidor: " + entrada.readLine());
            } while (!mensaje.equals("fin"));

        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }

    public void cerrar() {
        try {
            socket.close();
            System.out.println("Conexión cerrada");
        } catch (IOException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

