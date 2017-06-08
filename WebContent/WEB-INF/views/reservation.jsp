<%@page import="teamid9527.moviebooking.entities.Reservation"%>
<%@page import="teamid9527.moviebooking.entities.MovieItem"%>
<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>我的订单</title>
 <script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
 <script type="text/javascript">
 	$(function() {
 		$(".delete").click(function() {
 			var href = $(this).attr("href");
 			$("form").attr("action", href).submit();
 			return false;
 		})
 	}) 
</script>
</head>

<body>
	<h4>我的订单</h4>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	<!--  
	sessionScope.customer: ${sessionScope.customer2}	
	<br>
	sessionScope.reservation.customer: ${sessionScope.reservation.customer}	
	-->
	<%Reservation reservation = (Reservation)session.getAttribute("reservation");
	List<MovieItem> movieItems = reservation.getMovieItems();
	%>
	
	<table border="1" cellpadding="10" cellspacing="0"> 
	<tr>
		<td>放映场次id</td>
		<td>电影</td>
		<td>影院</td>
		<td>价格</td>
		<td>座位</td>
		<td>时间</td>
	</tr>
	<%if (movieItems != null)
	for (int i = 0; i < movieItems.size(); i++) { %>
		<tr>
			<td><%=movieItems.get(i).getId()%></td> 
			<td><%=movieItems.get(i).getMovie().getName()%></td>
			<td><%=movieItems.get(i).getCinema().getName()%></td>
			<td><%=movieItems.get(i).getPrice()%></td>
			<td><%=movieItems.get(i).getSeat()%></td>
			<td><%=movieItems.get(i).getDuration()%></td>
			<td><a class="delete"  href="MovieItem/<%=movieItems.get(i).getId()%>">删除</a></td>
		</tr> 
	<%} %>
	</table>
	<br> 
	<a href="backToInfo">返回</a>
	<br>
	<%if(request.getAttribute("exception") != null) { %>
		Exception: ${requestScope.exception}
	<% } %>
	<br>
		
	<!-- sessionScope.reservation.movieItems: ${sessionScope.reservation.movieItems} -->
</body>
</html>