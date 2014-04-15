<%--
    This page passes the chosen citation type to the appropriate
    controller method.
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citation</title>
    </head>
    <body>
        <h1>Create new citation</h1>
        <form:form commandName="citation" action="${pageContext.request.contextPath}/setFields" modelAttribute="citationType" method="POST">
            <p>Select citation type:</p>
            <select name="citationType" >
                <option name="article" value="article">article</option>
                <option name="inproceedings" value="inproceedings">inproceedings</option>
                <option name="book" value="book">book</option>
            </select>
            <input type="submit">
        </form:form>
    </body>
</html>