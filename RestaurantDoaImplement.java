package com.FoodDelivery.DoaImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.FoodDelivery.Doa.RestaurantDoa;
import com.FoodDelivery.Model.Restaurant;
import com.FoodDelivery.Model.User;

public class RestaurantDoaImplement implements RestaurantDoa {
	private String InsertRestaurant="Insert into `restaurant`(`restaurantid`,`name`,`address`,"
			+ "`phonenumber`,"
			+ "`cuisinetype`,`deliverytime`,`adminuserid`,`rating`,`isactive`,`imagepath`) values(?,?,?,?,?,?,?,?,?,?)";
	private String UpdateRestaurant= "update `restaurant` set name=? , address=? , phonenumber=? , cuisinetype=? ,deliverytime=?,"
			+ "isactive=? where restaurantid=?" ;
	
	private String GetRestaurnat="select * from restaurant where restaurantid=?";
	private String DeleteUser="delete from restaurant where restaurantid=?";
	private String GetAllRestaurnat="Select * from restaurant";
	@Override
	public List<Restaurant> getAllRestaurant() {
		Restaurant r=null;
		ArrayList<Restaurant> rest=new ArrayList<>();
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(GetAllRestaurnat);)
		{
			ResultSet result=pst.executeQuery();
			while(result.next())
			{
				int restaurantid=result.getInt("restaurantid");
				String name=result.getString("name");
				String address=result.getString("address");
				String phonenumber=result.getString("phonenumber");
				String cuisinetype=result.getString("cuisinetype");
				String deliverytime=result.getString("deliverytime");
				int adminuserid=result.getInt("adminuserid");
				String rating=result.getString("rating");
				String isactive=result.getString("isactive");
				String imagepath=result.getString("imagepath");
				
				
				r=new Restaurant(restaurantid, name, address, phonenumber, cuisinetype, deliverytime, adminuserid, rating, isactive, imagepath);
				rest.add(r);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rest;
			}

	@Override
	public Restaurant getRestaurant(int id) {
		Restaurant r=null;
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(GetRestaurnat);)
		{
			pst.setInt(1, id);
			ResultSet result=pst.executeQuery();
			while(result.next())
			{
				int restaurantid=result.getInt("restaurantid");
				String name=result.getString("name");
				String address=result.getString("address");
				String phonenumber=result.getString("phonenumber");
				String cuisinetype=result.getString("cuisinetype");
				String deliverytime=result.getString("deliverytime");
				int adminuserid=result.getInt("adminuserid");
				String rating=result.getString("rating");
				String isactive=result.getString("isactive");
				String imagepath=result.getString("imagepath");
				
				
				r=new Restaurant(restaurantid, name, address, phonenumber, cuisinetype, deliverytime, adminuserid, rating, isactive, imagepath);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(InsertRestaurant);)
		{
			
			pst.setInt(1,restaurant.getRestaurantId() );
			pst.setString(2,restaurant.getName() );
			pst.setString(3,restaurant.getAddress() );
			pst.setString(4, restaurant.getPhoneNumber());
			pst.setString(5, restaurant.getCuisineType());
			pst.setString(6,restaurant.getDeliveryTime() );
			pst.setInt(7, restaurant.getAdminUserId());
			pst.setString(8,restaurant.getRating() );
			pst.setString(9, restaurant.getRating());
			pst.setString(10, restaurant.getImagePath());
			
			int res=pst.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
		
		

	@Override
	public void updateRestaurant(Restaurant restaurant) {

		try (Connection con=DbConnetion.getConnection();
				PreparedStatement pst=con.prepareStatement(UpdateRestaurant);)
		{
			
			pst.setString(1, restaurant.getName());
			pst.setString(2, restaurant.getAddress());
			pst.setString(3, restaurant.getPhoneNumber());
			pst.setString(4, restaurant.getCuisineType());
			pst.setString(5, restaurant.getDeliveryTime());
			pst.setString(6, restaurant.getIsActive());
			pst.setInt(7, restaurant.getRestaurantId());
			
			int i=pst.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int id) {
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

}
