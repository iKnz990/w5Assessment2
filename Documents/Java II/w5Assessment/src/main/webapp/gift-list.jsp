<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method ="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
<td><input type="radio" name="id" value="${currentitem.id}"></td>
<td>${currentitem.gift}</td>
<td>${currentitem.name}</td>
<td>${currentitem.description}</td>
</tr>
</c:forEach>
</table>
<input type ="submit" value ="edit" name="doThisToItem">
<input type ="submit" value ="delete" name="doThisToItem">
<input type="submit" value ="add" name ="doThisToItem">
</form>
</body>
</html>