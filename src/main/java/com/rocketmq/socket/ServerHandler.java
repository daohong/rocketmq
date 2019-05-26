package com.rocketmq.socket;

import java.io.*;
import java.net.Socket;

public class ServerHandler implements Runnable{
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter  printWriter;
    public ServerHandler(Socket socket) {
        try {
            this.socket = socket;
            bufferedReader=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            printWriter=new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String str,string="";
            while((str=this.bufferedReader.readLine())!=null){
                string+=str;
            }
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
