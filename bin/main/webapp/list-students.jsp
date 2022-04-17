<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.* , java.text.DateFormat , java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LIST STUDETNS</title>
<link type="text/css" rel="stylesheet" href="afficher.css">

</head>

<%

Date date = Calendar.getInstance().getTime();

DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
String today = formatter.format(date);

//		<input type="hidden" name="group" value="${today }">
	//	<c:param name="timeOfSeance" value="<%=today
	
	String group = request.getParameter("group");

%>


<body>

	<div id="std-list" class="mb">
		<h1>LIST STUDENTS</h1>

		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Present</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempStudent" items="${etudListG }">
					<tr>
						<td>${tempStudent.id}</td>
						<td>${tempStudent.firstName.toUpperCase()}</td>
						<td>${tempStudent.lastName.toUpperCase() }</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
	
	<form action="TeacherServlet" method="get">
		<input type="hidden" name="command" value="ABSENSE"> 
		date : 
         <input name="date" type="text" value="<%=today%>">
         <input name="idTeacher" type="hidden" value="">
         <input name="group" type="hidden" value="<%=group%>">
		 <label>Add
			id of Student</label> <input type="text" name="absent"> <input
			type="submit" value="add absense">
	</form>

	=
	<br>	=
	<br>	=
	<br>	=
	<br>	=
	<br>
	
	


	choose date to consulter les absense

	<form action="TeacherServlet" method="get">
		<input type="hidden" name="command" value="SHOWABSENSE"> 
		<input type="hidden" name="idTeacher" value="1"> 
			
			<label>consulter
			Student</label> <input type="date" name="date"> <input
			type="submit" value="Consulter students">
	</form>
</body>
</html>