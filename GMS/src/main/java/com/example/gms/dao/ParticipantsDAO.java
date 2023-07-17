package com.example.gms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.gms.db.DB;
import com.example.gms.model.Batch;
import com.example.gms.model.Participant;

public class ParticipantsDAO implements DAO<Participant> {
	
	DB db = DB.getDB();	
	private String TAG = "[" + getClass().getSimpleName() + "] ";

	@Override
	public int create(Participant participant) {

		int result = 0;
		
		try {
			
			String sql = "INSERT INTO participants VALUES("
					+ "null, "
					+ "'" + participant.getName() + "', "
					+ "'" + participant.getPhone() + "', "
					+ "'" + participant.getEmail() + "', "
					+ "'" + participant.getBirthDate() + "', "
					+ "NULL" + ")";
			
			System.out.println(TAG + "SQL: " + sql);
							
			result = db.executeUpdate(sql);
			
			String message = result > 0 ? "Participant created successfully" : "Participant not created. Please try again.";
			System.out.println(TAG + message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	@Override
	public int update(Participant participant) {
		
		int result = 0;
		
		try {
			
			String bidString = (participant.getBid() == 0) ? null : Integer.toString(participant.getBid()); 
			
			String sql = "UPDATE participants SET "
					+ "name = '" + participant.getName() + "', "
					+ "phone = '" + participant.getPhone() + "', "
					+ "email = '" + participant.getEmail() + "', "
					+ "birthDate = '" + participant.getBirthDate() + "', "
					+ "bid = " + bidString + " "
					+ "WHERE pid = " + participant.getPid() + ";";
					
			System.out.println(TAG + "SQL: "+sql);
					
			result = db.executeUpdate(sql);
			String message = result > 0 ? "Participant updated successfully" : "Participant not updated. Please try again.";
			System.out.println(TAG + message);

		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return result;
	}

	

	public void deleteParticipant(int pid) {

		
	}

	
	
	@Override
	public int delete(int pid) {
		
		int result = 0;
		
		try {
			
			String sql = "DELETE FROM participants WHERE pid = " + pid;
			System.out.println(TAG + "SQL: "+sql);
			
			result = db.executeUpdate(sql);
			
			String message = result > 0 ? "Participant deleted successfully" : "Participant not deleted. Please try again.";
			System.out.println(TAG + message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}


	@Override
	public Participant get(int pid) {
		
		Participant participant = null;
		
		try {
			
			String sql = "SELECT * FROM participants WHERE pid=" + Integer.toString(pid);		
			ResultSet set = db.executeQuery(sql);
			
			if (set.next()) {
				
				participant = participantFromSet(set);
				
			} else {
				System.out.println(TAG + " couldn't find that participant");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return participant;

	}
	
	@Override
	public ArrayList<Participant> getAll() {
		
		ArrayList<Participant> participants = new ArrayList<Participant>();
		
		try {
			
			String sql = "SELECT * FROM participants";
			
			ResultSet set = db.executeQuery(sql);
			while(set.next()) {
						
				participants.add(participantFromSet(set));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return participants;	
	}
	
	public ArrayList<Participant> getAllWhereBidEquals(int bid) {
		
		ArrayList<Participant> participants = new ArrayList<Participant>();
		
		try {
			
			String sql = "SELECT * FROM participants WHERE bid="+Integer.toString(bid);
			
			ResultSet set = db.executeQuery(sql);
			while(set.next()) {
		
				participants.add(participantFromSet(set));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return participants;	
	}

	@Override
	public ArrayList<Participant> findByName(String name) {

		ArrayList<Participant> participants = new ArrayList<Participant>();
		
		try {
			
			String sql = "SELECT * FROM batches WHERE name = '" + name + "'";
			
			ResultSet set = db.executeQuery(sql);
			while(set.next()) {
				
				participants.add(participantFromSet(set));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return participants;
	
	}
	
	
	private Participant participantFromSet(ResultSet set) throws SQLException {
		
		Participant participant = new Participant();
		participant.setPid(set.getInt("pid"));  // Either Column number or Column label
		participant.setName(set.getString("name"));
		participant.setPhone(set.getString("phone"));
		participant.setEmail(set.getString("email"));
		participant.setBirthDate(set.getString("birthDate"));
		participant.setBid(set.getInt("bid"));
		return participant;
		
	}	

}


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