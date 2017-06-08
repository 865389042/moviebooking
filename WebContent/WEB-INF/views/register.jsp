<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%request.setCharacterEncoding("UTF-8");response.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>电影在线订票系统</title>
</head>
<body>
	<h4>注册</h4>
	<a href="gotoLogin">前往登录页面</a>
	<form action="register" method="post">
		用户名: <input type="text" name="name">
	 	<br>
	 	<!--  
	 	<p>此处应实现用户名不能为空的功能</p>-->
	 	密码: <input type="password" name="password">
	 	<br>
	 	<!-- 
	 	<p>此处应实现输入两次密码确认且不能为空的功能</p>
	 	<p>此处应当实现输入的密码只包括数字、字母、符号</p>
	 	 -->
	 	邮箱: <input type="text" name="email">
	 	<form:errors path="email"></form:errors>
	 	<!--  
	 	<p>此处应实现对邮箱进行正则表达式检测</p>
	 	-->
	 	<br>
	 	<input type="submit" value="注册">
	</form>
	<%if(request.getAttribute("exception") != null) { %>
		Exception: ${requestScope.exception}
	<% } %>
	
</body>
</html>