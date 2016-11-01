<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="register" method="post" modelAttribute="user">
		
		Name : <form:input path="userName"/> <br/>
		Email :<form:input path="userEmail"/> <br/>
		Password :<form:input path="userPassword"/> <br/>
		
		<input type="submit" value="Submit">
		
	</form:form>
	
</body>
</html>