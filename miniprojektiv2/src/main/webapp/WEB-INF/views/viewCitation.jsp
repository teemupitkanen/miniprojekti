<%-- 
    Document   : viewCitation
    Created on : Apr 2, 2014, 12:44:54 PM
    Author     : 41407
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viewing citation</title>
    </head>
    <body>
        <h1>${citation.title}</h1>
        <ul>
            <li>Author: ${citation.author}</li>
            <li>Book title: ${citation.booktitle}</li>
            <li>Year: ${citation.year}</li>
        </ul>
    </body>
</html>
