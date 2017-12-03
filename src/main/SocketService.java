package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by alden on 2017/12/3.
 */
public class SocketService {
    public static void main(String[] args) {
        SocketService socketService = new SocketService();
        socketService.onServer();
    }


    public void onServer() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1111);
            System.out.println("服务端启动，线程："+ Thread.currentThread().getId());
            Socket socket = null;
            socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println(in.readLine());
            String line = br.readLine();

            while (!line.equals("end")) {
                writer.println(line);
                writer.flush();
                System.out.println("Server:"+line);
                //在系统标准输出上打印读入的字符串
                System.out.println("Client:"+in.readLine());
                //从Client读入一字符串，并打印到标准输出上
                line = br.readLine();
            }

            writer.close(); //关闭Socket输出流
            in.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
            serverSocket.close(); //关闭ServerSocket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

