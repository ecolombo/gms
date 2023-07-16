package com.example.gms.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.gms.db.DB;
import com.example.gms.model.Batch;

public class BatchesDAO implements DAO<Batch> {
	
	DB db = DB.getDB();	
	private String TAG = "[" + getClass().getSimpleName() + "] ";
	
	int bid_default;
	
	public BatchesDAO() {
		createDefaultIfMissing();
	}
	
	public int getDefaultBID() {
		return bid_default;		
	}
	
	public void createDefaultIfMissing() {
		
		try {
			
			ArrayList<Batch> batches = findByName("DefaultBatch");

			if(batches.size() > 0) {
				
				bid_default = batches.get(0).getBid();

			} else {
				
				System.out.println("Default batch is missing in the DB. Creating default batch...");
				Batch batch = new Batch("DefaultBatch", "Participants are added to this batch by default");
				int result = create(batch);
				String message = (result > 0) ? "Default batch created." : "Error while creating default batch.";
				System.out.println(TAG + message);
				// find something smarter to do if default batch creation fails...
				batches = findByName("DefaultBatch");
				bid_default = batches.get(0).getBid();								
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int create(Batch batch) {
		
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO batches VALUES("
					+ "null, "
					+ "'" + batch.getName() + "', "
					+ "'" + batch.getDescription() + "' )";
			
			System.out.println(TAG + "SQL: " + sql);
							
			result = db.executeUpdate(sql);
			String message = (result > 0) ? "Batch created successfully" : "Batch nocht created. Please try again.";
			System.out.println(TAG + message);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
	
	
	@Override
	public int update(Batch batch) {
		
		int result = 0;
		
		try {
			
			String sql = "UPDATE batches SET"
					+ "name = '" + batch.getName() + "', "
					+ "description = '" + batch.getDescription() + "', "
					+ "WHERE bid = " + batch.getBid() + ";";
					
			System.out.println(TAG + "SQL: "+sql);
					
			db.executeUpdate(sql);
			
			result = db.executeUpdate(sql);
			String message = result > 0 ? "Batch updated successfully" : "Batch not updated. Please try again.";
			System.out.println(TAG + message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	

	@Override
	public int delete(int bid) {
		
		int result = 0;
		
		try {
			
			String sql = "DELETE FROM batches WHERE bid = " + bid;
			System.out.println(TAG + "SQL: "+sql);
			
			result = db.executeUpdate(sql);
			
			String message = result > 0 ? "Batch deleted successfully" : "Batch not deleted. Please try again.";
			System.out.println(TAG + message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;
		
	}

		
	@Override
	public ArrayList<Batch> getAll() {
		
		ArrayList<Batch> batches = new ArrayList<Batch>();
		
		try {
			
			String sql = "SELECT * FROM batches";
			
			ResultSet set = db.executeQuery(sql);
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

	public ArrayList<Batch> findByName(String name) {

		ArrayList<Batch> batches = new ArrayList<Batch>();
		
		try {
			
			String sql = "SELECT * FROM batches WHERE name = '" + name + "'";
			
			ResultSet set = db.executeQuery(sql);
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
