package com.example.gms.db;

import java.util.ArrayList;

import com.example.gms.model.Batch;
import com.example.gms.model.Participant;

public interface DAO {	
	
	// Ab hier reinkopiert, anpassen:
	void createConnection();
	void closeConnection();
	
	int createParticipant(Participant participant);	
	//todo: alle zu int konvertieren?
	void updateParticipant(Participant participant);
	void deleteParticipant(int pid);
	ArrayList<Participant> getAllParticipants();
	
	void createBatch(Batch batch);
	void updateBatch(Batch batch);
	void deleteBatch(int bid);
	ArrayList<Batch> findBatchesByName(String name);
	ArrayList<Batch> getAllBatches();
	

}
