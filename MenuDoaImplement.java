package com.FoodDelivery.DoaImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.FoodDelivery.Doa.MenuDoa;
import com.FoodDelivery.Model.Menu;
import com.FoodDelivery.Model.User;

public class MenuDoaImplement implements MenuDoa {

	private String InsertMenu="Insert into `menu`(menuid,restaurantid,itemname,description,price,isavailable,rating,imagepath)"
			+ "values(?,?,?,?,?,?,?,?)";
	private String GetMenuDetails="Select * from menu where menuid=?";
	private String UpdateMenu="update menu set restaurantid=? , itemname=?, description=?,price=?,isavailable=?, rating=?,imagepath=? where "
			+ "menuid=?";
	private String DeleteMenu="delete from menu where menuid=?";
	private String SelectMenuList="select * from menu";
	private String SelectMenuListByID="select * from menu where restaurantid=? ";
	
	

	@Override
	public List<Menu> getAllMenuDetails() {
		ArrayList<Menu> menuList=new ArrayList<>();
		try (Connection con=DbConnetion.getConnection();)
		{
			Statement pst=con.createStatement();
			ResultSet result=pst.executeQuery(SelectMenuList);
			while(result.next()) {
			int Menuid=result.getInt("menuid");
			int   restaurantid=result.getInt("restaurantid");
			String itemname=result.getString("itemname");
			String description=result.getString("description");
			double price=result.getDouble("price");
			String isavailable=result.getString("isavailable");
			String rating=result.getString("rating");
			String imagepath=result.getString("imagepath");
			
			Menu m=new Menu(Menuid, restaurantid, itemname, description, price, isavailable, rating, imagepath);
			menuList.add(m);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menuList;
	}

	@Override
	public Menu getMenuDetails(int id) {

		Menu m=null;
		// TODO Auto-generated method stub
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(GetMenuDetails);)
		{
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			while(result.next())
			{
				int menuid=result.getInt("menuid");
				int resid=result.getInt("restaurantid");
				String itemname=result.getString("itemname");
				String desc=result.getString("description");
				double price=result.getDouble("price");
				String isaval=result.getString("isavailable");
				String rating=result.getString("rating");
				String img=result.getString("imagepath");
			
				
				m=new Menu(menuid, resid, itemname, desc, price, isaval, rating, img);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub

		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(InsertMenu);)
		{
			
			pst.setInt(1, menu.getMenuId());
			pst.setInt(2, menu.getRestaurantId());
			pst.setString(3, menu.getItemname());
			pst.setString(4, menu.getDescription());
			pst.setDouble(5, menu.getPrice());
			pst.setString(6, menu.getIsavailable());
			pst.setString(7, menu.getRating());
			pst.setString(8, menu.getImagepath());
			
			int res=pst.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(UpdateMenu);)
		{
			
			pst.setInt(1, menu.getRestaurantId());
			pst.setString(2, menu.getItemname());
			pst.setString(3, menu.getDescription());
			pst.setDouble(4, menu.getPrice());
			pst.setString(5, menu.getIsavailable());
			pst.setString(6, menu.getRating());
			pst.setString(7, menu.getImagepath());
			pst.setInt(8, menu.getMenuId());
			
			int i=pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		

	@Override
	public void deleteMenu(int id) {
		// TODO Auto-generated method stub
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(DeleteMenu);)
		{
			
			pst.setInt(1, id);
			
			int i=pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public List<Menu> getAllMenuDetailsByRestaurantId(int resId) {
		ArrayList<Menu> menuList=new ArrayList<>();
		try (Connection con=DbConnetion.getConnection();)
		{
			PreparedStatement pst=con.prepareStatement(SelectMenuListByID );
			pst.setInt(1, resId);
			ResultSet result=pst.executeQuery();
			while(result.next()) {
			int Menuid=result.getInt("menuid");
			int   restaurantid=result.getInt("restaurantid");
			String itemname=result.getString("itemname");
			String description=result.getString("description");
			Double price=result.getDouble("price");
			String isavailable=result.getString("isavailable");
			String rating=result.getString("rating");
			String imagepath=result.getString("imagepath");
			
			Menu m=new Menu(Menuid, restaurantid, itemname, description, price, isavailable, rating, imagepath);
			menuList.add(m);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menuList;
	}

}
