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
<title>Delete a participant</title>
<link rel="stylesheet" href="gms.css">
</head>

<body>	
   
<H3>    
<%	
	try {	
					
		ParticipantsDAO participantsDAO = new ParticipantsDAO();
		
		int pid = Integer.valueOf(request.getParameter("pid"));
		
		Participant participant = participantsDAO.get(pid);
		
		int result = participantsDAO.delete(pid);		
		
		if (result > 0) {	
			out.println(participant.getName() + " deleted successfully.");		
		} else {
			out.println(participant.getName() + " not deleted. Please try again.");
		}	
	
	} catch (Exception e) {
		e.printStackTrace();
	}	
%>
</H3>

<a href="manageParticipants.jsp">Back to participant manager</a>

</body>
</html>