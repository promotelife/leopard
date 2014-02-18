package com.genius.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class svrThread  extends Thread  {
	private Socket cltSock;
	
	public svrThread(Socket socket) {
		 this.cltSock=socket;
	}
 
    public void run(){ 
        SocketAddress clientAddress=cltSock.getRemoteSocketAddress();  
        System.out.println("Handling client at "+clientAddress);  
        try{  
      //使用所返回的Socket实例的InputStream和OutputStream与客户端进行通信  
        BufferedReader br=new BufferedReader(new InputStreamReader(cltSock.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(cltSock.getOutputStream()));
        
        String readStr=null; 
        while((readStr=br.readLine())!=null){
        	readStr=clientAddress+readStr;
            System.out.println("收到报文:"+readStr);
            bw.write(readStr);
            bw.newLine();
            bw.flush();
        }
        
        if(bw!=null) bw.close();
        if(br!=null) br.close();
        }catch (Exception e)
        {
        	e.printStackTrace();
        }
       finally{
    		      //关闭该客户端套接字链接  
    	        try {
					cltSock.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
       }
      
    }
}
