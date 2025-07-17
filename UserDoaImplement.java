package com.FoodDelivery.DoaImplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.FoodDelivery.Doa.UserDoa;
import com.FoodDelivery.Model.User;

public class UserDoaImplement implements UserDoa{
	
	Scanner sc=new Scanner(System.in);
	static Connection con=null;
	private String InsertUser="Insert into `user`(`name`,`username`,`password`,`email`,"
			+ "`phonenumber`,"
			+ "`address`,`role`,`createdate`,`lastlogindate`) values(?,?,?,?,?,?,?,?,?)";
	private String UpdateUser="update `user` set `name`=?, `username`=?,`password`=?, `email`=? , `phonenumber`=? , `address`=? where "
			+ "`userid`=? ";
	private String GetUser="select * from user where userid =?";
	private String DeleteUser="delete from `user` where userid = ?";
	private String SelectUsersList="select * from `user`";
	private String GetUsername="select * from user where email =?";
	private String GetPassname="select * from user where password =?";
	private String GetEmail="select * from user where email =?";
	

	@Override
	public List<User> getAllUser() {
	
		ArrayList<User> userlist=new ArrayList<>();
		try (Connection con=DbConnetion.getConnection();)
		{
			Statement pst=con.createStatement();
			ResultSet result=pst.executeQuery(SelectUsersList);
			while(result.next()) {
			int Userid=result.getInt("userId");
			
			String name=result.getString("name");
			String username=result.getString("username");
			String password=result.getString("password");
			String email=result.getString("email");
			String phonenumber=result.getString("phonenumber");
			String address=result.getString("address");
			String role=result.getString("role");
			Timestamp createdate=result.getTimestamp("createdate");
			Timestamp lastlogin=result.getTimestamp("lastlogindate");
			
			User u=new User(Userid, name, username, password, email, phonenumber, address, role, createdate, lastlogin);
			userlist.add(u);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userlist;
	}

	@Override
	public User getUser(int id) {


		User u=null;
		// TODO Auto-generated method stub
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(GetUser);)
		{
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			while(result.next())
			{
				int Userid=result.getInt("userId");
				String name=result.getString("name");
				String username=result.getString("username");
				String password=result.getString("password");
				String email=result.getString("email");
				String phonenumber=result.getString("phonenumber");
				String address=result.getString("address");
				String role=result.getString("role");
				Timestamp createdate=result.getTimestamp("createdate");
				Timestamp lastlogin=result.getTimestamp("lastlogindate");
				
				u=new User(Userid, name, username, password, email, phonenumber, address, role, createdate, lastlogin);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return u;
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		
		
		int res=0;
		
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(InsertUser);)
		{
			
			pst.setString(1, user.getName());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPhoneNumber());
			pst.setString(6, user.getAddress());
			pst.setString(7, user.getRole());
			pst.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pst.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			res=pst.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(UpdateUser);)
		{
			
			pst.setString(1, user.getName());
			pst.setString(2, user.getUserName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getPhoneNumber());
			pst.setString(6, user.getAddress());
			pst.setInt(7, user.getUserId());
			
			int i=pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteuser(int id) {
		// TODO Auto-generated method stub
			try (Connection con=DbConnetion.getConnection();
					PreparedStatement pst=con.prepareStatement(DeleteUser);)
			{
				pst.setInt(1, id);
				
				int i=pst.executeUpdate();
				System.out.println(i);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
//	public String getUsername(String name) {
//
//
//		User u=null;
//		// TODO Auto-generated method stub
//		try (Connection con=DbConnetion.getConnection();
//				PreparedStatement pst=con.prepareStatement(GetUsername);)
//		{
//			pst.setString(1, name);
//			ResultSet result=pst.executeQuery();
//			while(result.next())
//			{
//				String username=result.getString("email");
//				String password=result.getString("password");
//				u=new User(username, password);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return u.getEmail();
//	}
//	public String getUserPassword(String name) {
//
//
//		User u=null;
//		// TODO Auto-generated method stub
//		try (Connection con=DbConnetion.getConnection();
//				PreparedStatement pst=con.prepareStatement(GetPassname);)
//		{
//			pst.setString(1, name);
//			ResultSet result=pst.executeQuery();
//			while(result.next())
//			{
//				String username=result.getString("email");
//				String password=result.getString("password");
//				u=new User(username, password);
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return u.getPassword();
//	}
	
	public User getUsername(String email) {


		User u=null;
		// TODO Auto-generated method stub
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(GetEmail);)
		{
			pst.setString(1, email);
			ResultSet result=pst.executeQuery();
			while(result.next())
			{
				int Userid=result.getInt("userId");
				String name=result.getString("name");
				String username=result.getString("username");
				String password=result.getString("password");
				String phonenumber=result.getString("phonenumber");
				String address=result.getString("address");
				String role=result.getString("role");
				Timestamp createdate=result.getTimestamp("createdate");
				Timestamp lastlogin=result.getTimestamp("lastlogindate");
				
				u=new User(Userid, name, username, password, email, phonenumber, address, role, createdate, lastlogin);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return u;
	}


	
	

}
