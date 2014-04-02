<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citations</title>
    </head>
    <body>
        <h1>Listing all citations</h1>
        <div>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Book title</th>
                    <th>Year</th>
                </tr>
                <pre>
                    <c:forEach var="citation" items="${citations}">
                <tr>
                    <td>${citation.title}</td>
                    <td>${citation.author}</td>
                    <td>${citation.booktitle}</td>
                    <td>${citation.year}</td>
                    <td><a href="/edit/${citation}">edit</a></td>
                    <td><a href="/delete/${citation}">delete</a></td>
                </tr>
                    </c:forEach>
                </pre>
            </table>
        </div>
        <p><a href="/new">Create new citation</a></p>
    </body>
</html>
