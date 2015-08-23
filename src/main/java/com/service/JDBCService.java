package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.film.Customer;
import com.film.Film;
import com.film.Language;


public class JDBCService {
	Connection conn = new ConnectionMySql().makeConnectionMySql();

	public boolean login(String fname,String password){
		ResultSet rs = null;
		String sql="select * from customer where first_name=? and last_name=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){
				rs.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}
	
	public List<Customer> customer(){
		ResultSet rs = null;
		List<Customer> list = new  ArrayList<Customer>();
		String sql="select first_name,last_name,address,email,customer_id,"
				+ "customer.last_update from customer,address where customer.address_id = address.address_id order by customer_id ";

		try {
			PreparedStatement ps = conn.prepareCall(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Customer cus = new Customer();
				cus.setFirst_name(rs.getString("first_name"));
				cus.setLast_name(rs.getString("last_name"));
				cus.setAddress(rs.getString("customer.last_update"));
				cus.setEmail(rs.getString("email"));
				cus.setCustomer_id(rs.getInt("customer_id"));
				cus.setLast_update(rs.getString("last_update"));
				list.add(cus);
				
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public void add(Customer cu,int id){

		String sql="INSERT INTO customer(first_name,last_name,email,address_id,store_id,create_date) VALUES(?,?,?,?,?,?);";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cu.getFirst_name());
			ps.setString(2,cu.getLast_name());
			ps.setString(3, cu.getEmail());;
			ps.setInt(4, id);
			ps.setInt(5, 1);
			ps.setString(6,"2015-8-24 19:23:15");
			ps.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(int id){
		System.out.println(id);
		String sql = "delete from payment where customer_id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			sql = "delete from rental where customer_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			sql = "delete from customer where customer_id=?";
			preparedStatement.setInt(1, id);
			System.out.println(id);
			preparedStatement.execute();
			System.out.println(id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->删除出错！");
		}

		
	}
	
	
	public Customer showOne(int id){
		ResultSet rs = null;
		String sql="select first_name,last_name,email,address from customer,address where customer.address_id=address.address_id and film_id=?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while(rs.next()){
				Customer cu = new Customer();
				cu.setFirst_name(rs.getString("first_name"));
				cu.setLast_name(rs.getString("last_name"));
				cu.setEmail(rs.getString("email"));
				cu.setAddress(rs.getString("address"));
				rs.close();
				return cu;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List addressname(){
		ResultSet rs = null;
		String sql="select address from address";
		List list = new  ArrayList();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("address"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public int addressid(String name){
		ResultSet rs = null;
		String sql="select address_id from address where address=?";

		try {
			System.out.println(name);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			rs = ps.executeQuery();
			rs.next();
			int a =rs.getInt("address_id");
			rs.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	
	
	public List<Customer> lang(){
		ResultSet rs = null;
		String sql="select address_id,address from address";
		List<Customer> list = new  ArrayList<Customer>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Customer cu = new Customer();
				cu.setAddress(rs.getString("address"));
				cu.setAddress_id(rs.getInt("address_id"));
				list.add(cu);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public void update(Film film,int id){
		ResultSet rs = null;
		String sql="update film set title=?,description=?,language_id=? where film_id=?";

		try {
			System.out.println(id);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,film.getTitle() );
			ps.setString(2, film.getDescription());
			ps.setInt(3, id);
			ps.setInt(4, film.getFilm_id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}



class ConnectionMySql {

	public Connection makeConnectionMySql(){

		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}