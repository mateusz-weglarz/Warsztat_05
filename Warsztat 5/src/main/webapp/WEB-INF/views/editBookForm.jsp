<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 12.05.2021
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit book</title>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<h2>Edit book</h2>
<form:form method="post" action="/admin/books/edit/${book.id}" modelAttribute="book">
    <br><label for="isbn">ISBN:</label>
    <form:input path="isbn" id="isbn" type="text"/>
    <b><form:errors path="isbn" cssClass="error"/></b>

    <br><label for="title">Title:</label>
    <form:input path="title" id="title" type="text"/>
    <b><form:errors path="title" cssClass="error"/></b>

    <br><label for="author">Author:</label>
    <form:input path="author" id="author" type="text"/>
    <b><form:errors path="author" cssClass="error"/></b>

    <br><label for="publisher">Publisher:</label>
    <form:input path="publisher" id="punlisher" type="text"/>
    <b><form:errors path="publisher" cssClass="error"/></b>

    <br><label for="type">Type:</label>
    <form:input path="type" id="type" type="text"/>
    <b><form:errors path="type" cssClass="error"/></b>
    <br>
    <button name="button" type="submit" value="save">Edit book</button>
    <button name="button" type="submit" value="cancel">Cancel</button>
</form:form>
</body>
</html>