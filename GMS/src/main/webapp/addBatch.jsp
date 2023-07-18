<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Define a new batch</title>
<link rel="stylesheet" href="gms.css">
</head>
<body>
<ul class="nav">
<li class="nav"><a href="manageBatches.jsp">Back to batches manager</a></li>
</ul>

		<h3>Define a new batch</h3>
		
		<form action="doAddBatch.jsp" method="post">
			<p>
				<b>Name:</b>
				<input type="text" name="txtName" placeholder="Earyl Birds Mornign Yoga"/>
			</p>
			<p>
				<b>description:</b>
				<input type="text" name="txtDescription" placeholder="6:00 am Yoga session"/>
			</p>
			<p>
				<input type="submit" value="Add"/>
			</p>			
		</form>
		
		

</body>
</html>