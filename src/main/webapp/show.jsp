<%@page import="java.util.ArrayList"%>
<%@page import="com.film.Film"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Film> list = new ArrayList(); 
  list = (ArrayList)session.getAttribute("list");%>
	<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
		align="center">
		<tr>
			<td>film_id</td>
			<td>title</td>
			<td>description</td>
			<td>language</td>
		</tr>

		<%for(int i=0;i<list.size();i++){
	  %>

		<tr>
			<td><%=list.get(i).getFilm_id() %></td>
			<td><%=list.get(i).getTitle() %></td>
			<td><%=list.get(i).getDescription()%></td>
			<td><%=list.get(i).getLanguage_name() %></td>
			<td><a href="<%= request.getContextPath() %>/DeleteServlet?typeid=<%=list.get(i).getFilm_id()%>" >删除</a></td>
		    <td><a href="<%= request.getContextPath() %>/ShowOneServlet?typeid=<%=list.get(i).getFilm_id()%>" >更新</a></td>
		</tr>
		
	
	<% } %>
</table>
<a href="<%=request.getContextPath()%>/GetLanguageServlet" >增加信息</a>


</body>
</html>