package part1.connection_test;

import java.io.IOException;
import java.net.*;

class ClientTest {
    public static void main(String[] args) {
        //1.
        //2.
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8080)) {
            System.out.println("success connection");



        } catch (IOException e) {
            System.out.println("Connection failed");
            throw new RuntimeException(e);
        }

    }
}
