<%@page import="teamid9527.moviebooking.entities.Cinema"%>
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
<title>Insert title here</title>
</head>
<body>
	<%	Map<Cinema, List<MovieItem>> map = (Map)session.getAttribute("cinemas");
		Set<Map.Entry<Cinema, List<MovieItem>>> movieItems = map.entrySet();
	%>
	<table>
		<tr>
			<td>影院id</td>
			<td>影院名</td>
			<td>影院地址</td>
			<td>stars</td>
			<td>info</td>
			<td>折扣</td>
		</tr>
		<%for(Map.Entry<Cinema, List<MovieItem>> movieItem : movieItems) { %>
			<tr>
				<td><%=movieItem.getKey().getId()%></td>
				<td><%=movieItem.getKey().getName()%></td>
				<td><%=movieItem.getKey().getAddress()%></td>
				<td><%=movieItem.getKey().getStars()%></td>
				<td><%=movieItem.getKey().getInfo()%></td>
				<td><%=movieItem.getKey().getMax_discount()%></td>
				<td><a href="queryMovieItemsByCinema?id=<%=movieItem.getKey().getId()%>">查看</a></td>
			</tr>
		<%}%>
	</table>
	<a href="backToInfo">返回</a>
	session cinemas:${sessionScope.cinemas}
</body>
</html>