package com.rocketmq.socket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
    private ServerSocket serverSocket;
    @Value("${socket.port}")
    private int port;
    @Value("${socket.threadNumber}")
    private int threadNumber;
    private ExecutorService pool;

    @Bean
    public ServerSocket getServer(){
        try {
            pool= Executors.newFixedThreadPool(threadNumber);
            serverSocket=new ServerSocket(port);
            Socket socket=serverSocket.accept();
            pool.execute(new ServerHandler(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverSocket;
    }
}
