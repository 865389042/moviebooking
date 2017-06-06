<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%request.setCharacterEncoding("UTF-8");response.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="gotoLogin">前往登录页面</a>
	<form action="register" method="post">
		username: <input type="text" name="name">
	 	<br>
	 	<p>此处应实现用户名不能为空的功能</p>
	 	password: <input type="password" name="password">
	 	<br>
	 	<p>此处应实现输入两次密码确认且不能为空的功能</p>
	 	<p>此处应当实现输入的密码只包括数字、字母、符号</p>
	 	email: <input type="text" name="email">
	 	<p>此处应实现对邮箱进行正则表达式检测</p>
	 	<br>
	 	<input type="submit" value="注册">
	</form>
	Exception: ${requestScope.exception}
	
</body>
</html>