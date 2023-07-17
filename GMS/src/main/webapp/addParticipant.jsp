<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a new participant</title>
<link rel="stylesheet" href="gms.css">
</head>
<body>
		<h3>Add a new participant</h3>
		
		<form action="doAddParticipant.jsp" method="post">
			<p>
				<b>Name:</b>
				<input type="text" name="txtName" placeholder="Hanna Schmidt"/>
			</p>
			<p>
				<b>Phone:</b>
				<input type="text" name="txtPhone" placeholder="+1 123 456 789"/>
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
				<input type="submit" value="ADD PARTICIPANT"/>
			</p>
			<input type="hidden" name="callAction" value="addParticipant"/>
		</form>
		
		<a href="manageParticipants.jsp">Return to participant manager</a>

</body>
</html>