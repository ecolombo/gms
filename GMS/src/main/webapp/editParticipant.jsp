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
<title>Edit participant</title>
<link rel="stylesheet" href="gms.css">
</head>
<body>
<ul class="nav">
<li class="nav"><a href="manageParticipants.jsp">Back to participant manager</a></li>
</ul>

<%
	int pid = Integer.valueOf(request.getParameter("pid"));
    ParticipantsDAO participantsDAO = new ParticipantsDAO();    
    Participant participant = participantsDAO.get(pid);
    BatchesDAO batchesDAO = new BatchesDAO();
    ArrayList<Batch> batches = batchesDAO.getAll();
    
%>


	<h3>Edit participant</h3>
		
		<form action="doEditParticipant.jsp" method="post">
			<p>
				<b>Name:</b>
				<input type="text" name="txtName" value="<%= participant.getName() %>"/>
			</p>
			<p>
				<b>Phone:</b>
				<input type="text" name="txtPhone" value="<%= participant.getPhone() %>"/>
			</p>
			<p>
				<b>Email:</b>
				<input type="text" name="txtEmail" value="<%= participant.getEmail() %>"/>
			</p>
			<p>
				<b>Birthdate:</b>
				<input type="date" name="dateBirthday" value="<%= participant.getBirthDate() %>"/><br>
			</p>
			<p>
			<b>Assigned batch:</b>
			<select name ="selBatch">
				<% 
					out.println("<option value='0'>None assigned</option>");
					for (Batch batch : batches) {
						String selectedString = "";
						if (participant.getBid() == batch.getBid()) { selectedString = " selected"; }
						
						String bidString = Integer.toString(batch.getBid());
						
						out.println("<option value='"+bidString+"'" + selectedString + ">"+batch.getName()+"</option>");
					}
				%>			
			</select>
			</p>						
			<p>
				<input type="submit" value="Save"/>
			</p>
			

			
			<input type="hidden" name="pid" value="<%= participant.getPid() %>"/>
			<input type="hidden" name="bid" value="<%= participant.getBid() %>"/>
			
			</form>

</body>
</html>