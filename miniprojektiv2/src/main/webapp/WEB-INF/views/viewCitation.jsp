<%-- 
    A page for viewing a chosen citation.
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Viewing citation</title>
    </head>
    <body>
        <h2>Citation: ${citation.citeType.name}</h2>
        <table>
            <c:forEach items="${citation.fields}" var="field">
                <tr>
                    <td>${field.key}:</td>
                    <td>${field.value}</td>
                </tr>
            </c:forEach>
                
        </table>
        <h3>Tags</h3>
                <c:forEach items="${addedtags}" var="tag">
                    <table>
                        <tr>
                            <td><a href="viewtag/${tag.id}">${tag.name}</a></td>
                        </tr>
                    </table>
                </c:forEach>  
            <h3>Add new tag</h3>
                <form:form commandName="tagwithnew" action="${pageContext.request.contextPath}/tagwithnew" method="POST">
                    <input name="tagName" value="">
                    <input type="hidden" name="citationId" value="${citation.id}">
                    <input name="addTag" type="submit" value="Create tag">
                </form:form>
                    <c:if test="${fn:length(missingtags) > 0}">
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
                </c:if>
        <br />
        <p><a href="/miniprojektiv2/listAll">Home</a></p>
    </body>
</html>
