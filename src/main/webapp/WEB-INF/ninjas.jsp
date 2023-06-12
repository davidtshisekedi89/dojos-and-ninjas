<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> 
<meta charset="ISO-8859-1">
<title>Insert Title Here</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form action="/ninjas/new" method="POST" modelAttribute="newNinja">
     <form:select path="dojo">
     
        <c:forEach var="eachDojo" items="${dojoList}">
        
            <form:option value="${eachDojo.id }"> ${eachDojo.name } </form:option>

        </c:forEach>
        
     </form:select>
     <p>
       <form:label path="firstName">First Name</form:label>
       <form:input type="text" path="firstName" />
       <form:errors path="firstName" />
     </p>
     
     <p>
       <form:label path="lastName">Last Name</form:label>
       <form:input type="text" path="lastName" />
       <form:errors path="lastName" />
     </p>
     
     <p>
       <form:label path="age">Age</form:label>
       <form:input type="number" path="age" />
       <form:errors path="age" />
     </p>
     
     <button type="submit">Create</button>

</form:form>

</body>
</html>