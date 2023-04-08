package part1.trans_file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServerTest {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket socket=serverSocket.accept();
            FileOutputStream fileOutputStream=new FileOutputStream("test/test2.txt");
            InputStream in=socket.getInputStream();

            int len;
            byte[] data=new byte[1024];
            while((len=in.read(data))!=-1){
                fileOutputStream.write(data,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
