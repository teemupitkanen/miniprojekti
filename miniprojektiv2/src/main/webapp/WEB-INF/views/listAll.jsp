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
        <h1>List of all citations</h1>
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

                    <td>${citation.fields.title}</td>
                    <td>${citation.fields.author}</td>
                    <td>${citation.fields.booktitle}</td>
                    <td>${citation.fields.year}</td>
                    <td><a href="citations/${citation.id}">view</a></td>
<!--
                    <td><a href="/edit/${citation.id}">edit</a></td>
                    <td><a href="/delete/${citation.id}">delete</a></td>
-->
                </tr>
                    </c:forEach>
                </pre>
            </table>
        </div>
        <p><a href="new">Create new citation</a></p>
        <p><a href="tag">Create new tag</a></p>
        <p><a href="bibtex">View citations in BibTeX format</a></p>
    </body>
</html>
