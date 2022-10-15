<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Create New List</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Who are the gifts for: <input type ="text" name ="listName"> <br/>

Who is giving the gift: <input type="text" name="gifter"><br/>

Available Items: <br/>
<select name="allItemsToAdd" multiple size="6">

<c:forEach items="${requestScope.listName }" var="currentgift">
	<option value ="${currentgift.id }"> ${currentgift.gift} ${currentgift.name }
</c:forEach>

</select>
<br/>
<input type ="submit" value="Create List and Add Gifts">
</form>
<a href = "index.html">Go add a new gift instead.</a>
</body>
</html>