package com.example.gms.model;

/*

	CREATE TABLE participants (
		pid INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(256),
		phone VARCHAR(20),
		email VARCHAR(256),
		birthDate DATE,
		bid INT,
		CONSTRAINT fk_bid FOREIGN KEY (bid)
		REFERENCES batches(bid)
	);
	
	
	// todo: BirthDate DATE bearbeiten!!
 
 */

public class Participant {
		
	int pid;
	String name;
	String phone;
	String email;
	String birthDate;
	int bid;
	
	public Participant () {
		
	}
	
	public Participant(int pid, String name, String phone, String email, String birthDate, int bid) {
		this.pid = pid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		this.bid = bid;
	}
	
	
	@Override
	public String toString() {
		return "Participant [pid=" + pid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", birthDate="
				+ birthDate + ", bid=" + bid + "]";
	}
	
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
	

}
