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
    <h1>New Dojo</h1>
    <form:form action="/dojos/new" method="POST" modelAttribute="newDojo">
     <p>
       <form:label path="name">Name</form:label>
       <form:input type="text" path="name" />
       <form:errors path="name" />
     </p>
     
     <button type="submit">Create</button>
    </form:form>
    
    
    
    

</body>
</html>