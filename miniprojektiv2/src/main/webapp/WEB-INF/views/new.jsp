<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citation</title>
    </head>
    <body>
        <h1>Create new citation</h1>
        <form:form commandName="citation" action="${pageContext.request.contextPath}/create" method="POST">
            <h2>Mandatory fields</h2>
            Author: <form:input path="author" /><form:errors path="author" /><br/>
            Title: <form:input path="title" /><form:errors path="title" /><br/>
            Book title: <form:input path="booktitle" /><form:errors path="booktitle" /><br/>
            Year: <form:input path="year" /><form:errors path="year" /><br/>
            <h2>Optional fields</h2>
            
            <!-- editor, volume/number, series, pages, address, month, organization, publisher, note, key -->
            Editor: <form:input path="editor" /><br/>
            Volume/number: <form:input path="volumeNumber" /><br/>
            Series: <form:input path="series" /><br/>
            Pages: <form:input path="pages" /><br/>
            Address: <form:input path="address" /><br/>
            Month: <form:input path="month" /><br/>
            Organization: <form:input path="organization" /><br/>
            Publisher: <form:input path="publisher" /><br/>
            Note: <form:input path="note" /><br/>
            Key: <form:input path="key" /><br/>
            
            <input type="submit">
        </form:form>
    </body>
</html>