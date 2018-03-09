<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <link rel="stylesheet"
          href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Shopping List Form</h2>
    <form:form modelAttribute="student"  action="result">
        <div class="form-group">
            <label>Choice(1)</label>
            <form:input cssClass="form-control" path="firstname" />
        </div>
        <div class="form-group">
            <label>Choice(2)</label>
            <form:input cssClass="form-control" path="lastname" />
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>
</div>
</body>
</html>