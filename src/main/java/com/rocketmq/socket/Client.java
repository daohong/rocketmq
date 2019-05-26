package com.rocketmq.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static  void main(String args[]){
        try {
            Socket socket=new Socket("127.0.0.1",8765);
            PrintWriter printWriter=new PrintWriter(new OutputStreamWriter( socket.getOutputStream()));
           // printWriter.println("233");
            //printWriter.flush();
            //printWriter.println("233");
            printWriter.write("233");
            printWriter.write("233");
            printWriter.flush();
            printWriter.write("233");
            printWriter.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
