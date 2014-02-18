package com.genius.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


/*
 * extractLog test_e = new extractLog();
 * test_e.tail(new File("d:/a.txt"));
 * */
public class extractLog {
	
	public static void tail(File file)
	{
		BufferedReader br;
		try {
			br = new BufferedReader( new InputStreamReader( new FileInputStream(file))); 
			
	       String strInput=null;  
	       boolean flag = true;
	       boolean flag2 = true;
	       String preMessage=null;
	       
	       //循环监控缓冲区
	       while(flag)
		   {
	    	   try{
	    		   strInput=br.readLine();
	    	   }catch(Exception e)
	    	   { } 
	    	   
	    	 //第一次加载的时候记录上一条记录
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
	    	   //遇到exit时退出读取
	    	   if(strInput!=null)
	    	   {	
	    		   //输出显示
	    		   System.out.println(strInput);
	    		   if (strInput.trim().equals("exit"))
	    		   {
	    			   flag=false;
	    		   }
	    	   }
		   }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
