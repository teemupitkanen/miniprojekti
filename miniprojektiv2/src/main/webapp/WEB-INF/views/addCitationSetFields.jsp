<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citation</title>
    </head>
    <body>
        <h1>Create new citation</h1>
        <p>Citation type: ${citationType}</p>
        <form:form commandName="citation" action="${pageContext.request.contextPath}/create" modelAttribute="citation" method="POST">
            <table>
                <tr>
                    <th>Key</th>
                    <th>Value</th>
                </tr>
                <c:forEach items="${citation.fields}" var="fields" varStatus="status">
                    <tr>
                        <td>${fields.key}</td>
                        <td> <input name="fields['${fields.key}']" value="${fields.value}"/></td>
                    </tr>                
                </c:forEach>
            </table> 
            <input type="submit">
        </form:form>
    </body>
</html>