<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%request.setCharacterEncoding("UTF-8");response.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>index page</h4>
	
	<form action="login" method="post">
		username: <input type="text" name="name">
	 	<br>
	 	password: <input type="password" name="password">
	 	<br>
	 	<input type="submit" value="登陆">
	</form>
</body>
</html>