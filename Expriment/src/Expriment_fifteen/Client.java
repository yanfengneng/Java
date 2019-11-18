package Expriment_fifteen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)throws Exception{
        //绑定到本地服务器127.0.0.1的888号端口
        Socket socket=new Socket("127.0.0.1",888);

        //用客户端的socket读取服务器中的输入流
        InputStreamReader reader=new InputStreamReader(socket.getInputStream());

        //将字符、数组和行高效地读取
        BufferedReader buffer_reader=new BufferedReader(reader);

        //客户端的socket中的输出流，用于向Server传送数据
        PrintWriter writer=new PrintWriter(socket.getOutputStream());

        System.out.println("服务器连接成功，准备向服务器发送请求...");

        String readline= "";
        Scanner input=new Scanner(System.in);//屏幕输入数据

        System.out.println("开始向服务器发送请求（exit结束通话）：");
        var count=0;
        while(!(readline=input.nextLine()).equals("exit")){//当数据输入exit时退出
            writer.println(readline);//将数据准备传入服务端
            writer.flush();//缓冲输出

            //客户端接收服务端的回应
            String response=buffer_reader.readLine();
            System.out.println("Server say:"+response);
        }

        System.out.println("请求结束，断开连接...");
        writer.println("exit");
        writer.flush();
        writer.close();
        buffer_reader.close();
        socket.close();
    }
}
