<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citations</title>
    </head>
    <body>
        <h1>Listing all citations</h1>
        <pre>
            <c:forEach var="citation" items="${citations}">
                ${citation}
            </c:forEach>
        </pre>
        <p><a href="miniprojektiv2/new">Create new citation</a></p>
    </body>
</html>
