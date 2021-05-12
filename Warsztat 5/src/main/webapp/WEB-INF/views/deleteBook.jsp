<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 12.05.2021
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Book</title>
</head>
<body>
<H2>Delete book:</H2>
<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${book.isbn}"/></td>
        <td><c:out value="${book.title}"/></td>
        <td><c:out value="${book.author}"/></td>
    </tr>
    </tbody>
</table>
<form:form action="/admin/books/delete/${book.id}" method="post">
    <button name="confirm" type="submit" value="delete">Delete</button>
    <button name="confirm" type="submit" value="cancel">Cancel</button>
</form:form>
</body>
</html>
