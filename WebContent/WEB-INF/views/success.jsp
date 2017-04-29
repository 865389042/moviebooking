<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<a href="queryReservation?c_id=${sessionScope.customer2.c_id}&name=${sessionScope.customer2.name}">查看用户订单</a>
	<br>
	<a href="queryMovieItems">查看电影</a>
	<br>
	<form action="update" method="post">
		<input type="hidden" name="c_id" value=${sessionScope.customer2.c_id}>
		<input type="hidden" name="name" value=${sessionScope.customer2.name}>
	 	new password: <input type="password" name="password">
	 	<p>此处应实现输入两次密码确认且不能为空的功能</p>
	 	<p>此处应当实现输入的密码只包括数字、字母、符号</p>
		email: <input type="text" name="email" value=${sessionScope.customer2.email}>
		<input type="submit" value="修改">
	</form>
	Exception: ${requestScope.exception}
	<br>
	<a href="gotoLogin">注销</a>
</body>
</html>