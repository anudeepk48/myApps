<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/angular.min.js"></script>
<script src="<%=request.getContextPath()%>/js/app.js"></script>
</head>
<body>
<div ng-controller="myController">
<input type="text" ng-model="name" />
<input type="text" ng-model="newName" />
 counter {{counter}}
 <br/>
 <span my-test-data> </span>
 <span my-test-data-html> </span>
</div>

<div ng-controller="testController">
 <span my-test-data-html> </span>
  Date format: <input ng-model="format"> <hr/>
  Current time is: <span my-current-time="format"></span>
</div>

</body>
</html>