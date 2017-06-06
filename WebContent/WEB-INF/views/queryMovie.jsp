<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="teamid9527.moviebooking.entities.MovieItem"%>
<%@page import="teamid9527.moviebooking.entities.Movie"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>电影</title>
</head>
<body>
	<h4>电影信息</h4>
	<%Map<Movie, List<MovieItem>> map = (Map)session.getAttribute("movies");
	Set<Map.Entry<Movie, List<MovieItem>>> movieItems = map.entrySet();
	%>
	<table  border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>电影id</td>
			<td>电影名</td>
			<td>类型</td>
			<td>stars</td>
		</tr>
		<%for(Map.Entry<Movie, List<MovieItem>> movieItem : movieItems) { %>
			<tr>
				<td><%=movieItem.getKey().getId()%></td>
				<td><%=movieItem.getKey().getName()%></td>
				<td><%=movieItem.getKey().getType()%></td>
				<td><%=movieItem.getKey().getStars()%></td>
				<td><a href="queryMovieItemsByMovie?id=<%=movieItem.getKey().getId()%>">查看</a></td>
			</tr>
		<%}%>
	</table>
	<a href="backToInfo">返回</a>
	<!-- session movies:${sessionScope.movies} -->
</body>
</html>