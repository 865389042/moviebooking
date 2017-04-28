<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>success</h4>
	
	request customer:${requestScope.customer2}
	<br><br>
	
	session customer:${sessionScope.customer2}
	<br>
	Name: ${sessionScope.customer2.name}
	<br>
	Password: ${sessionScope.customer2.password}
	<br>
	Email: ${sessionScope.customer2.email}
	<br><br>

</body>
</html>