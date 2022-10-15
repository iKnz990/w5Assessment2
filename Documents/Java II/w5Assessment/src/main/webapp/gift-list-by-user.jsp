<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Gift Lists</title>
</head>
<body>
<form method = "post" action ="listNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists }" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id }"></td>
	<td><h2>${currentlist.listName}</h2></td>
</tr>

<tr><td colspan="3">Gift Date: ${currentlist.tripDate }</td></tr>
<tr><td colspan="3">Giftee: ${currentlist.gifter.gifterName }</td></tr>
	<c:forEach var = "listVal" items = "${currentlist.listOfGifts }">
		
		<tr><td></td>
		<td colspan="3">
		${listVal.gift }, ${listVal.name }, ${listVal.description }
		</td>
		</tr>
	</c:forEach>
</c:forEach>
</table>

<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type = "submit" value = "add" name="doThisToList">

</form>
<a href="new-list.jsp">Create a new List</a>
<a href="index.html">Insert a new Item</a>
</body>
</html>