<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ page import="com.example.gms.db.DB" %>
<%@ page import="com.example.gms.dao.BatchesDAO" %>
<%@ page import="com.example.gms.model.Batch" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Define a new batch</title>
<link rel="stylesheet" href="gms.css">
</head>

<body>	
   
<H3>    
<%	
	try {
		
		Batch batch = new Batch();
		batch.setName(request.getParameter("txtName"));
		batch.setDescription(request.getParameter("txtDescription"));
					
		BatchesDAO batchesDAO = new BatchesDAO();
		int result = batchesDAO.create(batch);		
		
		// DEBUG:
		// out.println("Batch data: " + batch);
		
		if (result > 0) {	
			out.println(batch.getName() + " added to database successfully.");		
		} else {
			out.println(batch.getName() + " not added to database. Please try again.");
		}	
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
</H3>

<a href="manageBatches.jsp">Return to batches manager</a>

</body>
</html>