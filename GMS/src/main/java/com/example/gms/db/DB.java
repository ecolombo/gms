package com.example.gms.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.gms.model.Batch;
import com.example.gms.model.Participant;

public class DB implements DAO {
	
	Connection connection;
	Statement statement;
	int bid_default;
	
	final String TAG = "[" + getClass().getSimpleName() + "] ";
	
	public DB() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(TAG + "Driver loaded");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createConnection() {
		try {
			
			String user = "root";
			String password = "MySQL123.456";
			String url = "jdbc:mysql://localhost/gms"; // ACHTUNG, HIER RICHTIGE DB WAEHLEN!
			
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();			
			
			System.out.println(TAG + "Connection to DB created!");
			
			createDefault();
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void createDefault() {
		
		try {
			
			ArrayList<Batch> batches = findBatchesByName("DefaultBatch");

			if(batches.size() == 0) {
				System.out.println("Creating default batch...");
				Batch batch = new Batch("DefaultBatch", "Participants are added to this batch by default");
				createBatch(batch);
			}
			
			batches = findBatchesByName("DefaultBatch");
			bid_default = batches.get(0).getBid();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void closeConnection() {
		try {			
			connection.close();
			System.out.println(TAG + "Connection to DB closed! Close status: " + connection.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public int createParticipant(Participant participant) {
		
		int result = 0;
		
		try {
			
			System.out.println("bid: " + participant.getBid());
			
			String sql = "INSERT INTO participants VALUES("
					+ "null, "
					+ "'" + participant.getName() + "', "
					+ "'" + participant.getPhone() + "', "
					+ "'" + participant.getEmail() + "', "
					+ "'" + participant.getBirthDate() + "', "
					+ Integer.toString(bid_default) + ")";
			
			System.out.println(TAG + "SQL: " + sql);
							
			result = statement.executeUpdate(sql);
			
			String message = result > 0 ? "Participant created successfully" : "Participant not created. Please try again.";
			System.out.println(TAG + message);
			
			
			
			// Date --> YYYY-MM-DD
			// DateTime -> YYYY-MM-DD hh:mm:ss
			
			/*
			SimpleDateFormat pattern1 = new SimpleDateFormat("YYYY-MM-dd");
			SimpleDateFormat pattern2 = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
			
			Date date = new Date();
			String date1 = pattern1.format(date);
			String date2 = pattern2.format(date);
			*/
			
			// System.out.println("Date1: " + date1);
			// System.out.println("Date2: " + date2);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}

	public void updateParticipant(Participant participant) {
		try {
			
			String sql = "UPDATE participants SET"
					+ "name = '" + participant.getName() + "', "
					+ "phone = '" + participant.getPhone() + "', "
					+ "email = '" + participant.getEmail() + "', "
					+ "birthDate = '" + participant.getBirthDate() + "', "
					+ "bid = " + participant.getBid() + ", "
					+ "WHERE pid = " + participant.getPid() + ";";
					
			System.out.println(TAG + "SQL: "+sql);
					
			statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			String message = result > 0 ? "Participant updated successfully" : "Participant not updated. Please try again.";
			System.out.println(TAG + message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteParticipant(int pid) {
		try {
			
			String sql = "DELETE FROM participants WHERE pid = " + pid;
			System.out.println(TAG + "SQL: "+sql);
			
			int result = statement.executeUpdate(sql);
			
			String message = result > 0 ? "Participant deleted successfully" : "Participant not deleted. Please try again.";
			System.out.println(TAG + message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Participant> getAllParticipants() {
		
		ArrayList<Participant> participants = new ArrayList<Participant>();
		
		try {
			
			String sql = "SELECT * FROM participants";
			
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				Participant participant = new Participant();
				participant.setPid(set.getInt("cid"));  // Either Column number or Column label
				participant.setName(set.getString("name"));
				participant.setPhone(set.getString("phone"));
				participant.setEmail(set.getString("email"));
				participant.setBirthDate(set.getString("birthDate"));
				participant.setBid(set.getInt("bid"));			
				participants.add(participant);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return participants;
	}
	
	
	
	public void createBatch(Batch batch) {
		try {
			
			String sql = "INSERT INTO batches VALUES("
					+ "null, "
					+ "'" + batch.getName() + "', "
					+ "'" + batch.getDescription() + "' )";
			
			System.out.println(TAG + "SQL: " + sql);
							
			int result = statement.executeUpdate(sql);
			
			String message = result > 0 ? "Batch created successfully" : "Batch not created. Please try again.";
			System.out.println(TAG + message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateBatch(Batch batch) {
		try {
			
			String sql = "UPDATE batches SET"
					+ "name = '" + batch.getName() + "', "
					+ "description = '" + batch.getDescription() + "', "
					+ "WHERE bid = " + batch.getBid() + ";";
					
			System.out.println(TAG + "SQL: "+sql);
					
			statement = connection.createStatement();
			int result = statement.executeUpdate(sql);
			String message = result > 0 ? "Batch updated successfully" : "Batch not updated. Please try again.";
			System.out.println(TAG + message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteBatch(int bid) {
		try {
			
			String sql = "DELETE FROM batches WHERE bid = " + bid;
			System.out.println(TAG + "SQL: "+sql);
			
			int result = statement.executeUpdate(sql);
			
			String message = result > 0 ? "Batch deleted successfully" : "Batch not deleted. Please try again.";
			System.out.println(TAG + message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Batch> getAllBatches() {
		
		ArrayList<Batch> batches = new ArrayList<Batch>();
		
		try {
			
			String sql = "SELECT * FROM batches";
			
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				Batch batch = new Batch();
				batch.setBid(set.getInt("bid"));  
				batch.setName(set.getString("name"));
				batch.setDescription(set.getString("description"));
				batches.add(batch);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return batches;
	}
	
	public ArrayList<Batch> findBatchesByName(String name) {

		ArrayList<Batch> batches = new ArrayList<Batch>();
		
		try {
			
			String sql = "SELECT * FROM batches WHERE name = '" + name + "'";
			
			ResultSet set = statement.executeQuery(sql);
			while(set.next()) {
				Batch batch = new Batch();
				batch.setBid(set.getInt("bid"));  
				batch.setName(set.getString("name"));
				batch.setDescription(set.getString("description"));
				batches.add(batch);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return batches;
		
	}
	
	

}
