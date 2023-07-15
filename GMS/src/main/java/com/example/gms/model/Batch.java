package com.example.gms.model;


/*
 
 "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u root -p
→ Passwort: MySQL123.456

CREATE DATABASE gms;
USE gms;
CREATE TABLE batches (
	bid INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(256),
	description VARCHAR(1024)
);

*/


public class Batch {
	
	int bid;
	String name;
	String description;
	
	public Batch() {
		
	}

	public Batch(String name, String batchDescription) {
		
		// this.bid = bid;
		this.name = name;
		this.description = batchDescription;
	}


	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", name=" + name + ", batchDescription=" + description + "]";
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String batchDescription) {
		this.description = batchDescription;
	}
	
	

}
