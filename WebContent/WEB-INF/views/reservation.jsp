<%@page import="teamid9527.moviebooking.entities.Reservation"%>
<%@page import="teamid9527.moviebooking.entities.MovieItem"%>
<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	sessionScope.customer: ${sessionScope.customer}	
	<br>
	sessionScope.reservation.customer: ${sessionScope.reservation.customer}	
	<%Reservation reservation = (Reservation)session.getAttribute("reservation");
	Set<MovieItem> movieItems = reservation.getMovieItems();
	%>
	
	<table> 
	
	<%for (MovieItem movieItem : movieItems) {%> 
		<tr>
			<td><%=movieItem.getId()%></td> 
			<td><%=movieItem.getMovie().getName()%></td>
			<td><%=movieItem.getCinema().getName()%></td>
			<td><%=movieItem.getPrice()%></td>
			<td><%=movieItem.getSeat()%></td>
			<td><%=movieItem.getDuration()%></td>
		</tr> 
	<%}%> 
	</table> 

	sessionScope.reservation.movieItems: ${sessionScope.reservation.movieItems}	
	<a href="backToInfo">返回</a>

</body>
</html>