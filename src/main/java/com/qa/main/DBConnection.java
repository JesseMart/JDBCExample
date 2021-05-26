package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.utils.DBconfig;

public class DBConnection {

	private PreparedStatement ps;
	private Connection con; 
	private ResultSet rs;
	
	public DBConnection() throws SQLException {
		con = DriverManager.getConnection(DBconfig.url,DBconfig.user, DBconfig.pw);
	}
	
	//Create
	public void create(String name) throws SQLException {
		String sql = "INSERT INTO customers (name) VALUES (?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.execute();
	}
	//Read
	public void read() throws SQLException {
		String sql = "SELECT * FROM customers";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("nothing found!");
		} else {
			do {
				System.out.println(String.format("Id: %d, Name: %s", rs.getInt("id"), rs.getString("name")));
			} while(rs.next());
		}
	}
	public void readOne(int id) throws SQLException {
		String sql = "SELECT * FROM customers WHERE id = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if(!rs.next()) {
			System.out.println("nothing found!");
		} else {
			do {
				System.out.println(String.format("Id: %d, Name: %s", rs.getInt("id"), rs.getString("name")));
			} while(rs.next());
		}
	}
	
	//Update
	public void update(int uId, String name) throws SQLException {
		ps = con.prepareStatement("UPDATE customers SET name = ? WHERE id = ?");
		ps.setInt(2, uId);
		ps.setString(1, name);
		ps.execute()
;	}
	
	//Delete 
	public void delete(int id) throws SQLException {
		ps = con.prepareStatement("DELETE FROM customers WHERE id = ?");
		ps.setInt(1, id);
		ps.execute();
	}
	public void tearDown() throws SQLException {
		con.close();
	}
}
