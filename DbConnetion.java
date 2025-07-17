package com.FoodDelivery.DoaImplement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnetion {
	public static String url="jdbc:mysql://localhost:3306/fooddeliveryproject";
	public static String user="root";
	public static String password="Harsha@2002";
	static Connection con=null;
	
	
	public  static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(url,user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
