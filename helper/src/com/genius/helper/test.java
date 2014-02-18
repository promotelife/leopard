package com.genius.helper;

import java.io.File;

public class test {

	public static void main(String[] args)
	{
		/*
		extractLog test_e = new extractLog();
		test_e.tail(new File("d:/a.txt"));
		
		mysql test_mysql = new mysql();
		test_mysql.setDatabase("pgenius");
		test_mysql.getData("select * from STK_MKT limit 10;");
		
		*/
		mssql test_mssql = new mssql();
		test_mssql.setDatabase("cgenius");
		test_mssql.getData("select top 100 * from stk_mkt;");
	}
}
