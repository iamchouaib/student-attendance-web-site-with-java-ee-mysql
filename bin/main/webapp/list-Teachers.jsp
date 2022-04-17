<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Teachers</title>

<link type="text/css" rel="stylesheet" href="afficher.css">

</head>

<body>
<body>

	<div class="mb">
		<form action="LogOut" method="get">
		<input type="hidden"name="logout" value="admin">
			<button id="tech" class="logout">Logout</button>
		</form>

	</div>

	<div id="std-list" class="mb">
		<h1>LIST STUDENTS</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Last Name</th>
					<th>Group</th>
					<th>modifier</th>
					<th>suppremer</th>
				</tr>
			</thead>
			<tbody>
		<tr class="add">
				<c:forEach var="tempStudent" items="${STUDENTS }">
					<c:url var="tempLink" value="AdministratorServlet">
						<c:param name="command" value="LOADSTUDENT" />
						<c:param name="StudentID" value="${tempStudent.id }" />
					</c:url>
					<!-- link delete setup -->
					<c:url var="deleteLink" value="AdministratorServlet">
						<c:param name="command" value="DELETESTUDENT" />
						<c:param name="StudentID" value="${tempStudent.id }" />
					</c:url>
					<tr>
						<td>${tempStudent.firstName.toUpperCase()}</td>
						<td>${tempStudent.lastName.toUpperCase() }</td>
						<td>${tempStudent.group.toUpperCase() }</td>
						<td><a class="status btn btn-yellow status-pending" href="${tempLink }">Update</a>
						</td>
						<td><a class="status btn btn-red status-unpaid" href="${deleteLink }"
							onclick="if(!(confirm('are you sure u want delete this student?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
		
			</tbody>
		</table>
				
				<div class="add">
					<input type="button" value="Add STUDENT"
						class="status status-paid btn btn-green"
						onclick="window.location.href='add-Student.jsp' ; return false;">
					</div>


	</div>


	<div id="tech-list" class="mb">
		<h1>LIST TEACHER</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Last Name</th>
					<th>module</th>
					<th>modifier</th>
					<th>suppremer</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tempTeacher" items="${TEACHERS }">
					<c:url var="tempLink" value="AdministratorServlet">
						<c:param name="command" value="LOADTEACHER" />
						<c:param name="TeacherID" value="${tempTeacher.id }" />
					</c:url>

					<c:url var="deleteLink" value="AdministratorServlet">
						<c:param name="command" value="DELETETEACHER" />
						<c:param name="TeacherID" value="${tempTeacher.id }" />
					</c:url>

					<tr>
						<td>${tempTeacher.firstName.toUpperCase()}</td>
						<td>${tempTeacher.lastName.toUpperCase() }</td>
						<td>${tempTeacher.module.toUpperCase() }</td>
						<td><a class="status btn btn-yellow status-pending" href="${tempLink }">Update</a>
						</td>
						<td><a class="status btn btn-red status-unpaid" href="${deleteLink }"
							onclick="if(!(confirm('are you sure u want delete this Teacher?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
				<div class="add">
					<input type="button" value="Add TEACHER"
						class="status status-paid btn btn-green"
						onclick="window.location.href='add-Teacher.jsp' ; return false;">
					</div>
	</div>


</body>
</html>