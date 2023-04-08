package part1.loop_connection;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class SeverTest {
    public static void main(String[] args) throws IOException {
        //1.
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Waiting Connection...");
            //2. accept
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Socket connect! IP: " + socket.getInetAddress().getHostAddress());
                handle(socket);
                socket.close();
                System.out.println("socket close,waiting...");

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    private static void handle(Socket socket) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
             OutputStreamWriter outputStreamWriter=new OutputStreamWriter(socket.getOutputStream())) {
            char[] data = new char[1024];
            int len;
            while ((len = inputStreamReader.read(data)) != -1) {
                System.out.print("Client Input: ");
                System.out.print(new String(data, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
