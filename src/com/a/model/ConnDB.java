package com.a.model;

import java.sql.*;

public class ConnDB {

private Connection ct=null;
	
	//得到连接
	public Connection getConn(){
		
		try {
			//1.加载驱动
		    Class.forName("com.mysql.jdbc.Driver");
		    //2.得到连接
		   
		    this.ct=DriverManager.getConnection("jdbc:mysql://localhost:3306/china?user=root&password=1234&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&failOverReadOnly=false");
		    
		    if(this.ct.isClosed()){
		    	System.out.println("连接不成功！");
		    }
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return this.ct;
	}
	
}
