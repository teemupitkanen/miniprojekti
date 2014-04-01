<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citation</title>
    </head>
    <body>
        <h1>Create new citation</h1>
        <form:form commandName="citation" action="${pageContext.request.contextPath}/create" method="POST">
            Author: <form:input path="author" /><form:errors path="author" /><br/>
            Title: <form:input path="title" /><form:errors path="title" /><br/>
            Book title: <form:input path="booktitle" /><form:errors path="booktitle" /><br/>
            Year: <form:input path="year" /><form:errors path="year" /><br/>
            <input type="submit">
        </form:form>
    </body>
</html>