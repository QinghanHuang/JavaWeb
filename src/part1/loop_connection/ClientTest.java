package part1.loop_connection;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class ClientTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.
        //2.
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream())) {
            System.out.println("success connection");
            System.out.print("Please input: ");
            String strOut = scanner.nextLine();
            while (!strOut.equals("exit")) {

                outputStreamWriter.write(strOut + '\n');
                outputStreamWriter.flush();
                System.out.print("Please input: ");
                strOut = scanner.nextLine();
            }


        } catch (IOException e) {
            System.out.println("Connection failed");
            throw new RuntimeException(e);
        }

    }
}
