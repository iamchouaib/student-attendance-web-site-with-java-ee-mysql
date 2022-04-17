<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Teacher</title>
<link type="text/css" rel="stylesheet" href="app.css">
</head>

<body class="body1">

	<div class="row">
		<div class="teacher">

			<div class="login_form">
				<h3 class="heading-secendery u-margin-bottom-small u-center">I am  ${The_Teacher.firstName } </h3><img style="border-radius: 50%;" class="img-p" alt="" src="${The_Teacher.image }">

				<form action="TeacherServlet" class="form" method="GET">
					<input name="command" type="hidden" value="UPDATE">
        
						<input name="teacherID" type="hidden" value="${The_Teacher.id }">
						<input type = "hidden" name ="MYID" value ="${The_Teacher.id}"> 

					<div class="form_group">
						<input type="text" name="nom" id="name" value="${The_Teacher.firstName }"
							class="form_input" required> <label for="name"
							class="form_label">First Name</label>

					</div>

					<div class="form_group">

						<input type="text" name="prenom" id="prname" class="form_input"
							value="${The_Teacher.lastName }" required> <label for="prname"
							class="form_label">LastName</label>
					</div>


					<div class="form_group">
						<input type="text" name="groups" id="gp" class="form_input"
							value="${The_Teacher.groups }" > <label
							for="gp" class="form_label">groups</label>
					</div>


					<div class="form_group">

						<input type="text" name="module" id="md" class="form_input"
							value="${The_Teacher.module }" required> <label
							for="md" class="form_label" maxlength="4" >module</label>
					</div>
					
					<div class="form_group">

						<input type="email" name="email" id="em" class="form_input"
							value="${The_Teacher.email }" required> <label
							for="em" class="form_label" >Email</label>
					</div>
					<div class="form_group">
						<input type="submit" value="Update TEACHER " class="btn">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>