<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
    <%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/teacher.css">
<meta charset="ISO-8859-1">
<title>Welcome Teacher</title>
</head>
<body>
<div class="card-container">
		<span >
			

			<form action="LogOut" method="get">
				<input type="hidden"name="logout" value="teacher">
					<input type="submit" value="LogOut" class="logout" >
				</form>

		</span>
		<img class="round icon" src="${teacher.image}" alt="user" />
		<h3>${teacher.firstName} ${teacher.lastName }</h3>
		<h6>Constantine</h6>
		<p>${teacher.about }</p>
		<div class="buttons">

			<form action ="TeacherServlet" method="get">
				<input type = "hidden" name ="command" value ="LOAD"> 
				<input type = "hidden" name ="MYID" value ="${teacher.id}"> 
				
				<button class="btn btn-yellow-hollow">
					Update Profile
				</button>
			
				</form>

		</div>
		<form action="TeacherServlet" method="get">
			<input name =command type="hidden" value="APPALE">
				<div class="dropdown">
					<select name="group" class="btn btn-yellow-hollow" required>
						<option value="">Choose Group</option>
						<option value="1">group 1</option>
						<option value="2">group 2</option>
						<option value="3">group 3</option>
						<option value="4">group 4</option>
						
					</select>
				</div>
				<br>
				<button class="btn btn-yellow">
					Faire l'apple
				</button>
			</form>
	</div>
</body>
</html>