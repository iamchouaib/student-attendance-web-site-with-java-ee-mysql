<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="TeacherServlet" method="get">
<input name =command type="hidden" value="APPALE">
		<div class="dropdown">
			<select name="group" class="dropdown-select" required>
				<option value="">Choose Group</option>
				<option value="1">group 1</option>
				<option value="2">group 2</option>
				<option value="3">group 3</option>
			</select>
		</div>
		<br>
		<input type="submit" value ="Faire l'apple">
	</form>

</body>
</html>