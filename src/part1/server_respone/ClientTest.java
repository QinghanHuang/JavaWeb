package part1.server_respone;

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
            outputStreamWriter.write(strOut + '\n');
            outputStreamWriter.flush();
            socket.shutdownOutput();

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            System.out.println(bufferedReader.readLine());


        } catch (IOException e) {
            System.out.println("Connection failed");
            throw new RuntimeException(e);
        }

    }
}
