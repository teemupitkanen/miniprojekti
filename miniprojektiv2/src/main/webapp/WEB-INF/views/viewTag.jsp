<%-- 
    Document   : viewTag
    Created on : Apr 8, 2014, 10:57:24 PM
    Author     : lauri
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tag: ${tag.name}</title>
    </head>
    <body>
        <h1>${tag.name}</h1>
        <form:form commandName="tagwithnew" action="${pageContext.request.contextPath}/deletetag/{tag.id}" method="POST">
            <input type="hidden" name="tagId" value="${tag.id}">
            <input type="submit" value="Delete tag">
        </form:form>
    </body>
    <br/>
    <input type="button" value="Back" onclick="javascript:history.back()" />
</html>
