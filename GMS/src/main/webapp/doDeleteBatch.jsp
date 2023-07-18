<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ page import="com.example.gms.db.DB" %>
<%@ page import="com.example.gms.dao.BatchesDAO" %>
<%@ page import="com.example.gms.model.Batch" %>
<%@ page import="com.example.gms.dao.ParticipantsDAO" %>
<%@ page import="com.example.gms.model.Participant" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete a batch</title>
<link rel="stylesheet" href="gms.css">
</head>

<body>	
<ul class="nav">
<li class="nav"><a href="manageBatches.jsp">Back to batches manager</a></li>
</ul>

   
<%	
	try {	
		
		
		int bid = Integer.valueOf(request.getParameter("bid"));
		
		BatchesDAO batchesDAO = new BatchesDAO();		
		Batch batch = batchesDAO.get(bid);
		
		ParticipantsDAO participantsDAO = new ParticipantsDAO();
		ArrayList<Participant> participants = participantsDAO.getAllWhereBidEquals(bid);
		
		if (participants.size() > 0 ) {
			
			out.println("<p>The batch " + batch.getName() + " can not be deleted.");
			out.println("The following participant(s) are still inscribed to it:</p>");
			out.println("<p><ul>");
			for (Participant participant : participants) {
				out.println("<li><a href=editParticipant.jsp?pid="+participant.getPid()+">"+participant.getName()+"</a></li>");
			}
			out.println("</ul></p>");			
			out.println("<p>Unassign all participants from this batch then try again.</p>");
			
		} else {
			
			int result = batchesDAO.delete(bid);		
			
			if (result > 0) {	
				out.println("<H3>"+batch.getName() + " deleted successfully.</H3>");		
			} else {
				out.println("<H3>"+batch.getName() + " not deleted. Please try again.</H3>");
			}	

		}
		
		
		
	
	} catch (Exception e) {
		e.printStackTrace();
	}	
%>

</body>
</html>