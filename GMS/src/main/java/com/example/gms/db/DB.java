package com.example.gms.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.gms.dao.DAO;
import com.example.gms.model.Batch;
import com.example.gms.model.Participant;

public class DB {
	
	Connection connection;
	Statement statement;
	private static DB db = new DB();
	
	private String TAG = "[" + getClass().getSimpleName() + "] ";
	
	public static DB getDB() {
		return db;
	}

	public DB() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(TAG + "Driver loaded");
			initialize();
			System.out.println(TAG + "DB initialized");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		try {
			
			String user = "root";
			String password = "MySQL123.456";
			String url = "jdbc:mysql://localhost/gms"; // ACHTUNG, HIER RICHTIGE DB WAEHLEN!
			
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();			
			
			System.out.println(TAG + "Connection to DB created!");
									
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	

	public void close() {
		try {			
			connection.close();
			System.out.println(TAG + "Connection to DB closed! Close status: " + connection.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			System.out.println(TAG + "Executing SQL: " + sql);
			result = statement.executeUpdate(sql);
			System.out.println(TAG + "Statement executed");
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return result;
	}

	public ResultSet executeQuery(String sql) {		
		
		ResultSet set = null;
		
		try {
			System.out.println(TAG + "Executing SQL: " + sql);
			set = statement.executeQuery(sql);
			System.out.println(TAG + "Statement executed");
		} catch (Exception e) {
			e.printStackTrace();			
		}
		return set;
	}
	

}
