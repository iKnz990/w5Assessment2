<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Gift:<input type="text" name="gift" value="${itemToEdit.gift}">
Name:<input type="text" name="name" value="${itemToEdit.name}">
Description:<input type="text" name="description" value="${itemToEdit.description}">
<input type ="hidden" name ="id" value="${itemToEdit.id}">
<input type ="submit" value="Save Edited Item">
</form>

<a href ="viewAllItemsServlet">View the List</a>
</body>
</html>