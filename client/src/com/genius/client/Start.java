package com.genius.client;


import org.apache.log4j.Logger;

public class Start {
	public static void  main(String[] args)
	{
		Logger logger =  Logger.getLogger("test");
//		logger.info("haha");
		
		Client clt= new Client(8088);
		try{
		clt.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
