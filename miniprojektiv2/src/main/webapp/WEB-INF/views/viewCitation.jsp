<%-- 
    Document   : viewCitation
    Created on : Apr 2, 2014, 12:44:54 PM
    Author     : 41407
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h3>Tags<h3>
                <c:forEach items="${addedtags}" var="tag">
                    <table>
                        <tr>
                            <td><a href="viewTag/${tag.id}">${tag.name}</a></td>
                        </tr>
                    </table>
                </c:forEach>  
            <h3>Add new tag<h3>
                <form:form commandName="tagwithnew" action="${pageContext.request.contextPath}/tagwithnew" method="POST">
                    <input name="tagName" value="">
                    <input type="hidden" name="citationId" value="${citation.id}">
                    <input type="submit" value="Create tag">
                </form:form>
            <h3>Add existing tag<h3>
                <form:form commandName="tagwithexisting" action="${pageContext.request.contextPath}/tagwithexisting" method="POST">
                    <select name="tagId">
                    <c:forEach var="tag" items="${missingtags}">
                        <option value="${tag.id}">${tag.name}</option>
                    </c:forEach>
                    </select>
                    <input type="hidden" name="citationId" value="${citation.id}">
                    <input type="submit" value="Add tag">
                </form:form>
        <br />
        <input type="button" value="Back" onclick="javascript:history.back()" />
    </body>
</html>
