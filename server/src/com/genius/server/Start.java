package com.genius.server;

import org.apache.log4j.Logger;

public class Start {
	public static void  main(String[] args)
	{
		Logger logger =  Logger.getLogger("test");
		//logger.info("haha");
		Server svr = new Server(8088);
		try{
		svr.start();
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	}
}
