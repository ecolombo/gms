<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.gms.db.DB" %>
<%@ page import="com.example.gms.dao.ParticipantsDAO" %>
<%@ page import="com.example.gms.model.Participant" %>
<%@ page import="com.example.gms.dao.BatchesDAO" %>
<%@ page import="com.example.gms.model.Batch" %>
<%@ page import="java.util.ArrayList" %>

        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage participants</title>
<link rel="stylesheet" href="gms.css">
</head>
<body>
<ul class="nav">
<li class="nav"><a href="index.jsp">Back to home</a></li>
</ul>
<% 
	try {
		ParticipantsDAO participantsDAO = new ParticipantsDAO();
		ArrayList<Participant> participants = participantsDAO.getAll();
		
		BatchesDAO batchesDAO = new BatchesDAO();
		ArrayList<Batch> batches = batchesDAO.getAll();
		
		out.println("<table><tr><th>Name</th><th>Email</th><th>Phone</th><th>Birthdate</th><th>Batch</th><th>Actions</th></tr>");
		for (Participant participant : participants) {
			
			String batchName = "None assigned";
			if (participant.getBid() != 0) {
				Batch batch = batchesDAO.get(participant.getBid());
				batchName = batch.getName();
			}
			
			
			out.println("<tr><td>"+participant.getName()+"</td>"
						+ "<td>"+participant.getEmail()+"</td>"
						+ "<td>"+participant.getPhone()+"</td>"
						+ "<td>"+participant.getBirthDate()+"</td>"
						+ "<td>"+batchName+"</td>"
						+ "<td>"
						+"<ul class='actions'><li class='actions'><a href='editParticipant.jsp?pid="+participant.getPid()+"'>Edit</a></li> "
						+"<li class='actions'><a href='doDeleteParticipant.jsp?pid="+participant.getPid()+"'>Delete</a></li></ul>"
						+"</td></tr>");
		}
		out.println("</table>");	
	} catch (Exception e) {
		e.printStackTrace();
	}

%>

	<form action="addParticipant.jsp" method="post">
		<p><input type="submit" value="Add a participant"/></p>			
	</form>

</body>
</html>