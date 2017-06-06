<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8");response.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>电影在线订票系统</title>
</head>
<body>
	<h4>登录</h4>
	<a href="gotoRegister">前往注册页面</a>
	<br>
	<form action="login" method="post">
		用户名: <input type="text" name="name">
		<!-- <p>此处需要实现检查用户名不为空</p> -->
	 	<br>
	 	密码: <input type="password" name="password">
	 	<!-- <p>此处需要实现检查密码不为空</p> -->
	 	<br>
	 	<input type="submit" value="登陆">
	</form>
	<br>
	<a href="queryCinema">查看影院</a>
	<br>
	<a href="queryMovie">查看电影</a>	
	<br>
	<%if(request.getAttribute("exception") != null) { %>
		Exception: ${requestScope.exception}
	<% } %>

</body>
</html>