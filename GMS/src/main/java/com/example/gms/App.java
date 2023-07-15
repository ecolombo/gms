/*
 * todo: return result bei allen Funktionen von DB?
 * Weiter mit Demo 4.4
 * 
 * Probably, operations implemented in JSP, see Demo JSP-JDBC!!
 * 
 * Erst html, dann FrontController?
 * 
 * Make addParticipant html/jsp (OR RATHER A PARTICIPANT CONTROLLER AS IN EXAMPLE?)
 *    implement selectDate input and make format fit with SQL
 * Make ShowAllParticipants html/jsp with option for delete (/update)
 * (make update participant jsp)
 * 
 * Make add Batch jsp
 * Make editBatchParticipants jsp --> show all, delete, ADD
 * implement add dropdown
 * 
 * Listener registration to inform participant like cabs? Optional
 * 
 * package
 * 
 */




package com.example.gms;

import java.util.ArrayList;

import com.example.gms.db.DB;
import com.example.gms.model.Batch;

public class App {

	public static void main(String[] args) {

		System.out.println("Welcome to Gym Management System");
		
		System.out.println("Connecting to DB...");
		
		DB db = new DB();
		db.createConnection();
		
		// Create default batch if not yet created
		if(db.findBatchesByName("DefaultBatch").size() == 0) {
			System.out.println("Creating default batch...");
			Batch batch = new Batch("DefaultBatch", "Participants are added to this batch by default");
			db.createBatch(batch);
		}

		
		
		
		
		
		db.closeConnection();

	}

}
