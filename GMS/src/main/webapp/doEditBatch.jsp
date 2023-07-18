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
<title>Update batch</title>
<link rel="stylesheet" href="gms.css">
</head>

<body>	
<ul class="nav">
<li class="nav"><a href="manageBatches.jsp">Back to batches manager</a></li>
</ul>

<H3>    


<%	
	try {
		
		Batch batch = new Batch();
		batch.setBid(Integer.valueOf(request.getParameter("bid")));		
		batch.setName(request.getParameter("txtName"));
		batch.setDescription(request.getParameter("txtDescription"));
					
		BatchesDAO batchesDAO= new BatchesDAO();
		int result = batchesDAO.update(batch);
		
		// DEBUG:
		// out.println("Participant data: " + participant);
		
		if (result > 0) {	
			out.println(batch.getName() + " updated successfully.");		
		} else {
			out.println(batch.getName() + " not updated. Please try again.");
		}	
	
	} catch (Exception e) {
		e.printStackTrace();
	}	
%>
</H3>

</body>
</html>