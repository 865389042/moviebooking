<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>个人中心</title>
 <script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
 <script type="text/javascript">
 	$(function() {
 		$(".update").hide();
 		$(".show").click(function() {
 			if ($(".update").is(":hidden"))
 				$(".update").show();
 			else
 				$(".update").hide();
 			return false;
 		})
 	}) 
</script>
</head>
<body>
	<h4>我的信息</h4>
	<!--  
	request customer:${requestScope.customer2}
	<br><br>
	session customer:${sessionScope.customer2}
	<br>
	-->
	用户名: ${sessionScope.customer2.name}
	<br>
	邮箱: ${sessionScope.customer2.email}
	<br>
	<button class="show">修改个人信息</button>
	<form class="update" action="update" method="POST">
		
		<input type="hidden" name="c_id" value=${sessionScope.customer2.c_id}>
		<input type="hidden" name="name" value=${sessionScope.customer2.name}>
	 	新密码: <input type="password" name="password">
	 	<!-- 
	 	
	 	<p>此处应实现输入两次密码确认且不能为空的功能</p>
	 	<p>此处应当实现输入的密码只包括数字、字母、符号</p>
	 	 -->
	 	 <br>
		邮箱: <input type="text" name="email" value=${sessionScope.customer2.email}>
		<input type="submit" value="修改">
	</form>
	<br>
	<a href="reservation">
		查看用户订单
	</a>
	<br>
	<a href="queryCinema">查看影院</a>
	<br>
	<a href="queryMovie">查看电影</a>	
	<br>
	<%if(request.getAttribute("exception") != null) { %>
		Exception: ${requestScope.exception}
	<% } %>
	<br>
	<a href="gotoLogin">注销</a>
</body>
</html>