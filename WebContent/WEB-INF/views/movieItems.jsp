<%@page import="teamid9527.moviebooking.entities.MovieItem"%>
<%@page import="teamid9527.moviebooking.entities.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>电影场次</title>
 <script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
 <script type="text/javascript">
 	$(function() {
 		$(".add").click(function() {
 			var href = $(this).attr("href");
 			$("form").attr("action", href).submit();
 			return false;
 		})
 	}) 
</script>
</head>
<body>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="PUT">
	</form>
	<%List<MovieItem> movieItems = (List)session.getAttribute("movieItems");
	Boolean login = (((Customer)session.getAttribute("customer2")).getC_id() != null);
	%>
	<%if (!movieItems.isEmpty()) {%>
	<table  border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>场次id</td>
			<td>电影名</td>
			<td>影院</td>
			<td>价格</td>
			<td>座位</td>
			<td>时间</td>
		</tr>
		<%} else { %>
			<p>该影院现暂无上映场次</p>
		<%} %>
		<%for(MovieItem movieItem : movieItems) { %>
			<tr>
				<td><%=movieItem.getId()%></td>
				<td><%=movieItem.getMovie().getName()%></td>
				<td><%=movieItem.getCinema().getName()%></td>
				<td><%=movieItem.getPrice()%></td>
				<td><%=movieItem.getSeat()%></td>
				<td><%=movieItem.getDuration()%></td>
				<%if(login) { %>
				<td><a class="add" href="MovieItem/<%=movieItem.getId()%>">添加</a></td>
				<% } %>
			</tr>
		<%}%>
	</table>
	
	<input type="button" name="back" value="返回上一层" onclick="javascript:history.back(-1);"/>
	<%if(login) { %>
		<a href="backToInfo">返回用户信息</a>
	<% } %>
	
	<!-- 
	<input type=button value=后退 onclick="window.history.go(-1)">
	session movieItems:${sessionScope.movieItems}  -->
</body>
</html>