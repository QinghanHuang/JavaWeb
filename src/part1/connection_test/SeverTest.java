package part1.connection_test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class SeverTest {
    public static void main(String[] args) throws IOException {
        //1.
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Waiting Connection...");
            //2. accept
            Socket socket=serverSocket.accept();
            System.out.println("Socket connect! IP: "+socket.getInetAddress().getHostAddress());

        }catch (IOException e){
            System.out.println(e.getMessage());

        }

    }
}
