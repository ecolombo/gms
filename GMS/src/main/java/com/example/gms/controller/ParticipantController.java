package com.example.gms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.gms.dao.ParticipantsDAO;
import com.example.gms.db.DB;
import com.example.gms.model.Participant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParticipantController
 */
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ParticipantController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("callAction");
			
		if (action.equals("addParticipant")) {

			addParticipant(request, response);
		
		} else {
			// String url = "404.html";
			// RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			// dispatcher.forward(request, response);
			System.out.println("[ParticipantController]: POST action not recognized");
		}
		
		
	}
	
	void addParticipant(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
			Participant participant = new Participant();
			participant.setName(request.getParameter("txtName"));
			participant.setEmail(request.getParameter("txtEmail"));
			participant.setPhone(request.getParameter("txtPhone"));
			participant.setBirthDate(request.getParameter("dateBirthday"));
			
			System.out.println("[ParticipantController Servlet] Participant data: " + participant);
			
			/* DB db = new DB();
			db.createConnection();
			int result = db.createParticipant(participant);
			db.closeConnection();*/
						
			ParticipantsDAO participantsDAO = new ParticipantsDAO();
			int result = participantsDAO.create(participant);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Add a participant</title>\r\n<link rel=\"stylesheet\" href=\"gms.css\">\r\n</head>\r\n<body>");
			
			String message = "";
			if (result > 0) {
				message = participant.getName() + " added to database successfully.";
			} else {
				message = participant.getName() + " not added to database. Please try again.";
			}
			out.println("<p><h3>"+message+"</h3></p>");
			
			
			// participant.Ganzzahl = Integer.parseInt(request.getParameter(""));
			out.println("</body>\r\n</html>");			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
