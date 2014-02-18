package com.genius.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {   
    private int port=8088;
    
    public Server(int _port)
    {
    	port=_port;
    }
     
    public  void start() throws IOException, InterruptedException{ 
    	start(port);
    } 
    public  void start(int svrPort) throws IOException, InterruptedException{  
        //创建ServerSocket,监听指定端口
        ServerSocket svrSock=new ServerSocket(svrPort);  
           
        //监听
        while(true){  
        	//调用ServerSocket的accept()方法以获取客户端连接。  
            //基于新建立的客户端连接，创建一个Socket实例，并由accept()方法返回  
            Socket cltSock=svrSock.accept();  
            svrThread tclnt = new svrThread(cltSock);
            tclnt.start();
        }  
    }  
}  