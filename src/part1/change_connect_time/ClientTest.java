package part1.change_connect_time;

import java.io.IOException;
import java.net.*;

class ClientTest {
    public static void main(String[] args) {
        //1.
        //2.
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("127.0.0.1",8080));
            System.out.println("success connection");



        } catch (IOException e) {
            System.out.println("Connection failed");
            throw new RuntimeException(e);
        }

    }
}
