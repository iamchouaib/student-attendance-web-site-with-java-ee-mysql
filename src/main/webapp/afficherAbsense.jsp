<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher Absense</title>
</head>
<body>
	<c:set var="cities" value="setif , alger , oran , constantine" />

	<c:set var="citiesArray" value="${fn:split(cities , ',') }" />

	<c:forEach var="tempCity" items="${citiesArray }">
	${tempCity} <br>
	</c:forEach>
</body>
</html>