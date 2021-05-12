<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 12.05.2021
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h2>Book list</h2>
<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>actions</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href="/admin/books/edit/${book.id}">Edit book</a>
                <a href="/admin/books/confirm-delete/${book.id}">Delete book</a>
                <a href="/admin/books/find/${book.id}">Show book</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/admin/books/add">Add book</a></p>
</body>
</html>


