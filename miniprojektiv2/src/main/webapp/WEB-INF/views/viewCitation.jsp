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
        <h2>Citation</h2>
        <table>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>

            <tr>
                <td>
                    Citation id:
                </td>
                <td>
                    ${citation.citeId}
                </td>
            </tr>

            <tr>
                <td>
                    Title:
                </td>
                <td>
                    ${citation.fields.title}
                </td>
            </tr>

            <tr>
                <td>
                    Author:
                </td>
                <td>
                    ${citation.fields.author}
                </td>
            </tr>
            <tr>
                <td>
                    Year:
                </td>
                <td>
                    ${citation.fields.year}
                </td>
            </tr>

            <tr>
                <td>
                    Book title:
                </td>
                <td>
                    ${citation.fields.booktitle}
                </td>
            </tr>

            <!--
            <c:forEach items="${citation.fields}" var="field">
                <tr>
                    <td>${fields.key}</td>
                    <td>${fields.value}</td>
                </tr>
            </c:forEach>
            -->
        </table>
        <br />
        <input type="button" value="Back" onclick="javascript:history.back()" />
    </body>
</html>
