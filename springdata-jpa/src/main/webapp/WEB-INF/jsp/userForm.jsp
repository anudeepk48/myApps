<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form commandName="user" action="/test/userForm" method="post" id="submitForm">    
	<span>username</span> <input name="name" type="text" />
	<span>password</span> <input name="password" type="text" />
	<input type="submit" value="login" />
</form:form>
</body>
</html>