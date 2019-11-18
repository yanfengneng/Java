package Expriment_fifteen;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Server {

    public static class SocketHandler implements Runnable{
        private Socket socket;

        //构造函数
        SocketHandler(Socket socket){
            this.socket=socket;
        }

        //@Override
        public void run() {
            try{
                //用服务端的socket读取Client端的输入流数据
                InputStreamReader reader=new InputStreamReader(socket.getInputStream());

                //将字符、数组和行高效地读取
                BufferedReader buffer_reader=new BufferedReader((reader));

                //服务端的socket的输出流数据，用于向client传送信息
                PrintWriter writer=new PrintWriter(socket.getOutputStream());

                System.out.println("服务器开启成功，等待客户端连接...");

                String request="";
                while(true){//循环读取客户端的请求，直到遇到exit
                    //(request=buffer_reader.readLine())!="exit"
                    request=buffer_reader.readLine();
                    System.out.println("Client say:"+request);
                    if(Objects.equals(request, "exit"))break;
                    System.out.print("回应请求：");
                    String readline= "";
                    Scanner input=new Scanner(System.in);//屏幕输入数据
                    readline=input.nextLine();
                    writer.println(readline);
                    writer.flush();
                }
                System.out.println("通话结束!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws Exception{
        ServerSocket server=new ServerSocket(888);

        while(true){
            //等待客户端的连接，为客户创建socket
            Socket socket=server.accept();

            //用于某个客户端的通信
            SocketHandler handler= new SocketHandler(socket);

            //创建一个新的线程
            Thread thread=new Thread(handler);

            //线程开始
            thread.start();
        }
    }
}
