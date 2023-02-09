package ejemplo5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor capaz de manejar varios clientes concurrentes
 */
public class MulticlientServer {

    static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        
    	ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server levantado...");

            while (true) {
            //Se bloquea hasta que sucede la conexi�n
                Socket socket = s.accept();
                try {
                    new ClientHandler(socket);
                } catch (IOException e) {
                    // Si hay alg�n fallo, se cierra el socket.
                    socket.close();
                }

            }       
    }
}
