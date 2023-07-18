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
<title>Add a new participant</title>
<link rel="stylesheet" href="gms.css">
</head>
<body>
<ul class="nav">
<li class="nav"><a href="manageParticipants.jsp">Back to participant manager</a></li>
</ul>

<%
    BatchesDAO batchesDAO = new BatchesDAO();
    ArrayList<Batch> batches = batchesDAO.getAll();
    
%>



		<h3>Add a new participant</h3>
		
		<form action="doAddParticipant.jsp" method="post">
			<p>
				<b>Name:</b>
				<input type="text" name="txtName" placeholder="Hanna Schmidt"/>
			</p>
			<p>
				<b>Phone:</b>
				<input type="text" name="txtPhone" placeholder="+1 123 456 7890"/>
			</p>
			<p>
				<b>Email:</b>
				<input type="text" name="txtEmail" placeholder="Schmidt@mail.com"/>
			</p>
			<p>
				<b>Birthdate:</b>
				<input type="date" name="dateBirthday" value="2000-01-01"/><br>
			</p>
			<p>
			<b>Assigned batch:</b>
			<select name ="selBatch">
				<% 
					out.println("<option value='0'>None assigned</option>");
					for (Batch batch : batches) {
						
						String bidString = Integer.toString(batch.getBid());
						out.println("<option value='"+bidString+"'>"+batch.getName()+"</option>");
					}
				%>			
			</select>
			</p>				
			<p>
				<input type="submit" value="Add"/>
			</p>
			<input type="hidden" name="callAction" value="addParticipant"/>
		</form>
		
		

</body>
</html>