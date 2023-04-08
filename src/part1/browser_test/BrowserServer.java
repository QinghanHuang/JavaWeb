package part1.browser_test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BrowserServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Waiting");
            Socket socket = serverSocket.accept();
            System.out.println("Connection Success!");

            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);  //通过
            System.out.println("接收到客户端数据：");
            //为什么没有这一行 就显示网络连接错误!!!!!
            while (reader.ready()) System.out.println(reader.readLine());   //ready是判断当前流中是否还有可读内容


            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("HTTP/1.1 200 Accepted\r\n");   //200是响应码，Http协议规定200为接受请求，400为错误的请求，404为找不到此资源（不止这些，还有很多）
            writer.write("\r\n");   //在请求头写完之后还要进行一次换行，然后写入我们的响应实体（会在浏览器上展示的内容）
            writer.write("Clement");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
