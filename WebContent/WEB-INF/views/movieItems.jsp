<%@page import="teamid9527.moviebooking.entities.MovieItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%List<MovieItem> movieItems = (List)session.getAttribute("movieItems");%>
	<table>
		<tr>
			<td>场次id</td>
			<td>电影名</td>
			<td>影院</td>
			<td>价格</td>
			<td>座位</td>
			<td>时间</td>
		</tr>
		<%for(MovieItem movieItem : movieItems) { %>
			<tr>
				<td><%=movieItem.getId()%></td>
				<td><%=movieItem.getMovie().getName()%></td>
				<td><%=movieItem.getCinema().getName()%></td>
				<td><%=movieItem.getPrice()%></td>
				<td><%=movieItem.getSeat()%></td>
				<td><%=movieItem.getDuration()%></td>
				<td><a href="addMovieItem?id=<%=movieItem.getId()%>">添加</a></td>
			</tr>
		<%}%>
	</table>
	<a href="backToInfo">返回</a>
	session movieItems:${sessionScope.movieItems}
</body>
</html>