package com.genius.helper;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.apache.log4j.Logger;
/*
mssql ms= new mssql();
ms.getData("select top 10 * from cgenius..stk_mkt");
*/ 
public class mssql {
	private Logger log= Logger.getLogger(this.getClass().getName());
	//默认数据库连接信息
	private String host="172.18.3.7";
	private String port="1433";
	private String user="dba";
	private String password="DBA&sa";
	private String database="cgenius"; 
	
	public mssql()
	{
		
	}
	public mssql(String host,String user,String password)
	{
		this.host=host;
		this.user=user;
		this.password=password;
		
	}
	public mssql(String host,String port,String user,String password)
	{
		this.host=host;
		this.port=port;
		this.user=user;
		this.password=password;
		
	}
	public void getData(String strsql)
	{
		String url ="jdbc:sqlserver://"+host+":"+port+";DatabaseName="+ database  ;    //jdbc:mysql://host_name:port/dbname 注意首尾空格
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//创建连接
			Connection conn = DriverManager.getConnection(url,user,password);
			//创建声明
			Statement stmt = conn.createStatement();
			//执行SQL语句，获得结果集
			ResultSet rs = stmt.executeQuery(strsql);
			//获取元数据
			ResultSetMetaData rsmd=rs.getMetaData();
			StringBuffer sb= new StringBuffer();
			//输出列名
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				sb.append(rsmd.getColumnName(i)+"\t"); 
			} 
			log.info(sb);
			//逐行输出数据
			while (rs.next())
			{   
				sb.delete(0,sb.length()-1);
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					sb.append(rs.getString(i)+"\t");
				}
				log.info(sb);
			} 
			//关闭
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e)
		{
//			e.printStackTrace();
			log.error("ERROR:Connect DataBase Failed!");
		}
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
}
