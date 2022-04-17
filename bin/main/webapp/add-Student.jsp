<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="app.css">
<title>Add Student</title>
</head>

<body class="body1">

    <div class="row">
        <div class="student">

            <div class="login_form">
                <h3 class="heading-secendery u-margin-bottom-small u-center">ADD STUDENT
                </h3>

	<form action="AdministratorServlet" class="form" method="GET">
		<input name="command" type="hidden" value="ADDSTUDENT">
		<div class="form_group">
			<input type="text" name="nom" id="name" placeholder="First Name"
				class="form_input" required> <label for="name"
				class="form_label">First Name</label>

		</div>

		<div class="form_group">

			<input type="text" name="prenom" id="prname" class="form_input"
				placeholder="Last Name" required> <label for="prname"
				class="form_label">LastName</label>
		</div>
		
				<div class="form_group">

			<input type="text" name="group" id="gp" class="form_input"
				placeholder="Group" required> <label for="gp"
				class="form_label">Group</label>
		</div>
		
		
		<div class="form_group">
			<input type="submit" value="Add Student " class="btn">
		</div>
	</form>
           </div>


        </div>


    </div>

</body>
</html>