<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveUser" method="post">
	<div>
	  <input type="hidden" name="id" value="${user.id}" />
	 <div>Username <input type="text" name="name" value="${user.name}" /><br/></div>
	 <div>Age <input type="text" name="age" value="${user.age}"  /><br/></div>
	</div>
	<br/>
	<c:if test="${empty user.id}">
		<input type="submit" value="save" />
	</c:if>
	<c:if test="${not empty user.id}">
		<input type="submit" value="update" />
	</c:if>
	</form>

</body>
</html>