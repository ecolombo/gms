<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ page import="com.example.gms.db.DB" %>
<%@ page import="com.example.gms.dao.ParticipantsDAO" %>
<%@ page import="com.example.gms.model.Participant" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a participant</title>
<link rel="stylesheet" href="gms.css">
</head>

<body>	
   
<H3>    
<%	
	try {

		Participant participant = new Participant();
		participant.setName(request.getParameter("txtName"));
		participant.setEmail(request.getParameter("txtEmail"));
		participant.setPhone(request.getParameter("txtPhone"));
		participant.setBirthDate(request.getParameter("dateBirthday"));
					
		ParticipantsDAO participantsDAO = new ParticipantsDAO();
		int result = participantsDAO.create(participant);
		
		// DEBUG:
		// out.println("Participant data: " + participant);
		
		if (result > 0) {	
			out.println(participant.getName() + " added to database successfully.");		
		} else {
			out.println(participant.getName() + " not added to database. Please try again.");
		}	
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
</H3>

<a href="manageParticipants.jsp">Back to participant manager</a>

</body>
</html>