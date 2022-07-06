<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table><tr><td><a href="addBook">Add a new Book</a></td></tr></table>
<table border="1">
<thead>
<tr><th>Id</th><th>Title</th><th>Author</th><th>Category</th><th>Action</th>
</thead>
<tbody>
<c:forEach items="$(books)" var="b">
<tr>
<td>${b.id}</td><td>${b.title}</td><td>${b.author}</td>
<td>${b.category}</td>
<td><a href="addBook">update</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>