<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listing all citations in BibTex form</h1>
            <c:forEach var="citation" items="${citations}">
                <p>${citation.bibTexForm}<br><br></p>
            </c:forEach>
        
        <p><a href="/">Home</a></p>
    </body>
</html>
