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
<div class="container mt-5">

<h1 style="color:tomato;"><c:out value="${oneDojo.name}"></c:out></h1>

<table class="table table-success table-striped">
  <thead>
    <tr>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="eachNinja" items="${oneDojo.ninjas}">
  <tr>
      
      <td><c:out value="${eachNinja.firstName}" /></td>
      <td><c:out value="${eachNinja.lastName}" /></td>
      <td><c:out value="${eachNinja.age}" /></td>
      <
      
  </tr>
  </c:forEach>
    
  </tbody>
</table>

</div>

</body>
</html>