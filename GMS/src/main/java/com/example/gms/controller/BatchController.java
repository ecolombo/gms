package com.example.gms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.gms.dao.BatchesDAO;
import com.example.gms.dao.ParticipantsDAO;
import com.example.gms.model.Batch;
import com.example.gms.model.Participant;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BatchController
 */
public class BatchController extends HttpServlet implements Servlet {
	
	private static final long serialVersionUID = 1L;
	private String TAG = "[" + getClass().getSimpleName() + "] ";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchController() {
        // TODO Auto-generated constructor stub
    }
    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("callAction");
			
		if (action.equals("addBatch")) {

			addBatch(request, response);
		
		} else {
			// String url = "404.html";
			// RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			// dispatcher.forward(request, response);
			System.out.println(TAG + "POST action not recognized");
		}
		
		
	}
	
	void addBatch(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
			Batch batch = new Batch();
			batch.setName(request.getParameter("txtName"));
			batch.setDescription(request.getParameter("txtDescription"));
			
			System.out.println(TAG + "Batch data: " + batch);
			
			/* DB db = new DB();
			db.createConnection();
			int result = db.createParticipant(participant);
			db.closeConnection();*/
						
			BatchesDAO batchesDAO = new BatchesDAO();
			int result = batchesDAO.create(batch);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Add a participant</title>\r\n<link rel=\"stylesheet\" href=\"gms.css\">\r\n</head>\r\n<body>");
			
			String message = "";
			if (result > 0) {
				message = batch.getName() + " added to database successfully.";
			} else {
				message = batch.getName() + " not added to database. Please try again.";
			}
			out.println("<p><h3>"+message+"</h3></p>");
			
			
			// participant.Ganzzahl = Integer.parseInt(request.getParameter(""));
			out.println("</body>\r\n</html>");			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}    



}
