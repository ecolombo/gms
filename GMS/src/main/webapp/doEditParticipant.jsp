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
<title>Update participant</title>
<link rel="stylesheet" href="gms.css">
</head>

<body>	
<ul class="nav">
<li class="nav"><a href="manageParticipants.jsp">Back to participant manager</a></li>
</ul>
   
<H3>    
<%	
	try {	
			
	
		Participant participant = new Participant();
	    participant.setPid(Integer.valueOf(request.getParameter("pid")));
	    participant.setName(request.getParameter("txtName"));
		participant.setEmail(request.getParameter("txtEmail"));
		participant.setPhone(request.getParameter("txtPhone"));
		participant.setBirthDate(request.getParameter("dateBirthday"));
		
		String bidString =  request.getParameter("selBatch");
		if (Integer.valueOf(bidString) != 0) {
			participant.setBid(Integer.valueOf(bidString));
		}
					
		ParticipantsDAO participantsDAO = new ParticipantsDAO();
		int result = participantsDAO.update(participant);
		
		// DEBUG:
		// out.println("Participant data: " + participant);
		
		if (result > 0) {	
			out.println(participant.getName() + " updated successfully.");		
		} else {
			out.println(participant.getName() + " not updated. Please try again.");
		}	
	
	} catch (Exception e) {
		e.printStackTrace();
	}	
%>
</H3>

</body>
</html>