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
	<a href="saveUser">Add User</a>
	<table>
    <thead>
     <tr>
       <th>name</th>
       <th>age</th>
     </tr>
    </thead>
    <tbody>
    	<c:forEach var="user" items="${users}">
		<tr>
       		<td><a href="show?id=${user.id}">${user.name}</a></td>
       		<td>${user.age}</td>
     	</tr>
		</c:forEach>
    </tbody>
   
   </table>
	
</body>
</html>