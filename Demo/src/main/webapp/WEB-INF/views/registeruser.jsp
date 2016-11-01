<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="registeruser" method="post" modelAttribute="users">
		
		UserName : <form:input path="username"/> <br/>
		Password :<form:input path="password"/> <br/>
		Fname :<form:input path="fname"/> <br/>
		Mname:<form:input path="mname"/> <br/>
		Lname :<form:input path="lname"/> <br/>
		Gender :<form:input path="gender"/> <br/>
	    Status :<form:input path="status"/> <br/>
       

		
		<input type="submit" value="Submit">
		
	</form:form>
	


</body>
</html>