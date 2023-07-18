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
<title>Edit batch</title>
<link rel="stylesheet" href="gms.css">
</head>
<body>
<ul class="nav">
<li class="nav"><a href="manageBatches.jsp">Back to batches manager</a></li>
</ul>

<%
   
	int bid = Integer.valueOf(request.getParameter("bid"));
	BatchesDAO batchesDAO = new BatchesDAO();
    Batch batch = batchesDAO.get(bid);
    
    
%>


	<h3>Edit batch</h3>
		
		<form action="doEditBatch.jsp" method="post">
			<p>
				<b>Name:</b>
				<input type="text" name="txtName" value="<%= batch.getName() %>"/>
			</p>
			<p>
				<b>Description:</b>
				<input type="text" name="txtDescription" value="<%= batch.getDescription() %>"/>
			</p>
			<p>
				<input type="submit" value="Save"/>
			</p>
			<input type="hidden" name="bid" value="<%= batch.getBid() %>"/>						
		</form>

</body>
</html>