package part1.trans_file;

import java.io.*;
import java.net.*;

public class FileClientTest {
    public static void main(String[] args) {

        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8080)) {
            FileInputStream fileInputStream=new FileInputStream("test/test1.txt");
            OutputStream outputStream = socket.getOutputStream();
            int len;
            byte[] data=new byte[1024];
            while((len=fileInputStream.read(data))!=-1){
                outputStream.write(data,0,len);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
