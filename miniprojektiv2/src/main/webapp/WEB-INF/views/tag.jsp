<%-- 
    This is a page that lets the user handle tags.
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tags</title>
    </head>
    <body>
        <h1>List of all tags</h1>
        <table>
            <tr>
                <th>Tag</th>
            </tr>
            <pre>
                <c:forEach var="tag" items="${tags}">
                    <tr>
                        <td>${tag.name}</td>
                        <td><a href="deletetag/${tag.id}">delete</a></td>
                    </tr>
                </c:forEach>
            </pre>
            <h3>Create a new tag:</h3>
            <form:form commandName="tag" action="${pageContext.request.contextPath}/createtag" modelAttribute="tag" method="POST">
                <table>
                    <tr>
                        <%-- seuraavaksi hyvin epävarma rivi --%>
                        <td><input name="tagname" value=""</td>
                    </tr>
                </table>
                <input type="submit" value="Save">
            </form:form>
        </table>
        <p><a href="listAll">Back to list of all citations</a></p>
    </body>
</html>
