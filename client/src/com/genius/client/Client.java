package com.genius.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 *@ClassName:Server
 *@author: promote  
 *@date :2014-2-10  10:35:09
 *@Description:TODO 
 */
public class Client {
	private String serverip="localhost"; 
	private int port=8088;
	
	public Client(int _port)
	{
		port=_port;
	}
	public Client(String _serverip,int _port)
	{
		serverip=_serverip;
		port=_port;
	} 

    public  void start() throws UnknownHostException, IOException, InterruptedException
    {
    	start(serverip,port);
    }
	
    public  void start(String _serverip,int _port) throws UnknownHostException, IOException, InterruptedException {    
        //创建TCP连接  
        Socket cltSock=new Socket(_serverip,_port);  
        System.out.println("Connected to server "+_serverip+" : "+String.valueOf(_port));  
          
        //建立输入输出对象 
        BufferedReader br=new BufferedReader(new InputStreamReader(cltSock.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(cltSock.getOutputStream()));
         
        //定义读取键盘的流对象
	   //BufferedReader brk=new BufferedReader( new InputStreamReader(System.in));
       //定义读取文本的流对象
//	   BufferedReader brk=new BufferedReader( new FileReader("d:/a.txt"));
	   BufferedReader brk=new BufferedReader( new InputStreamReader( new FileInputStream(new File("d:/a.txt"))));
	    
       String strInput=null; 
       String strBack=null; 
//	   while((strInput=brk.readLine())!=null)
//	   {
//	        bw.write(strInput);
//	        bw.newLine();
//	        bw.flush(); 
//	        
//	        
//	        if((strBack=br.readLine())!=null){
//	            System.out.println("已发送报文:"+strBack); 
//	        } 
//		   
//	   } 
       boolean flag = true;
       boolean flag2 = true;
       String preMessage=null;
       while(flag)
	   {
    	   try{
    		   strInput=brk.readLine();
    	   }catch(Exception e)
    	   { } 
    	   
    	   if(flag2)
    	   {
    		   if(strInput!=null)
    		   {
    			   preMessage=strInput;
    		   }
    		   if(strInput==null)
    		   {
    			   strInput=preMessage;
    			   flag2=false;
    		   }
    		   else
    		   {
    			   continue;
    		   }
    	   } 
    	   
    	   if(strInput!=null)
    	   {
    		   if (strInput.equals("exit"))
    		   {
    			   flag=false;
    		   }
	        bw.write(strInput);
	        bw.newLine();
	        bw.flush(); 
	        
	        
	        if((strBack=br.readLine())!=null){
	            System.out.println("已发送报文:"+strBack); 
	        } 
    	   }
		   
	   } 

       if(br!=null) br.close(); 
        if(bw!=null) bw.close();  
        //关闭连接  
        cltSock.close();  
    }  
}  