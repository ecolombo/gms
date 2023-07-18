package com.example.gms;

import java.util.ArrayList;

import com.example.gms.db.DB;
import com.example.gms.model.Batch;

public class App {

	public static void main(String[] args) {

		System.out.println("Welcome to Gym Organizer");
		
		System.out.println("Connecting to DB...");
		
		DB db = new DB();
		
		db.close();

	}

}
