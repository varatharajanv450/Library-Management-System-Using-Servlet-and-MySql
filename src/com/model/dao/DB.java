package com.model.dao;

import java.sql.*;

public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","123456");
		if(con!=null)
		{
			System.out.println("Connection Successfully");
		}
		else
		{
			System.out.println("Connection Failed");
		}
		
	}catch(Exception e){System.out.println(e);}
	return con;
}
}
