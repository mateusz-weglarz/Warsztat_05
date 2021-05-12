<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 12.05.2021
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
</head>
<body>

<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>publisher</th>
    <th>type</th>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td><a href="/admin/books/edit/${book.id}">Edit book</a></td>
            <td><a href="/admin/books/confirm-delete/${book.id}">Delete book</a></td>
        </tr>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/admin/books/all">Book list</a></p>
</body>
</html>
