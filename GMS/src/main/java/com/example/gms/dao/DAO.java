package com.example.gms.dao;

import java.util.ArrayList;

import com.example.gms.model.Batch;
import com.example.gms.model.Participant;

public interface DAO<T> {	
	
	int create(T object);
	T get(int id);
	int update(T object);
	int delete(int id);
	ArrayList<T> getAll();
	ArrayList<T> findByName(String name);
	
}
