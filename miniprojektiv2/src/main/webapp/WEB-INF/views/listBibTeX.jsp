<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listing in BibTeX-form</title>
    </head>
    <body>
        <h1>All citations in BibTex form:</h1>
        <div>
            <c:forEach var="citation" items="${citations}">
                <p>${citation.bibTexForm}<br></p>
            </c:forEach>
        </div>
        <p><a href="/">Home</a></p>
    </body>
</html>
