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
<title>Manage batches</title>
<link rel="stylesheet" href="gms.css">
</head>
<body>
<a href='index.jsp'>Back to home</a>
<% 

	try {
		
		BatchesDAO batchesDAO = new BatchesDAO();
		ArrayList<Batch> batches = batchesDAO.getAll();
		
		out.println("<table><tr><th>Name</th><th>Description</th><th>Actions</th></tr>");
		for (Batch batch : batches) {
			
			out.println("<tr><td>"+batch.getName()+"</td>"
						+ "<td>"+batch.getDescription()+"</td>"
						+ "<td>"
						+"<a href='editBatch.jsp?bid="+batch.getBid()+"'>Edit</a>&nbsp;-&nbsp;"
						+"<a href='doDeleteBatch.jsp?bid="+batch.getBid()+"'>Delete</a>"
						+"</td></tr>");
		}
		out.println("</table>");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

<a href='addBatch.jsp'>Define a new batch</a>

</body>
</html>