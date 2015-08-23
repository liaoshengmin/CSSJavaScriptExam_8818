<%@page import="com.film.Film"%>
<%@page import="com.film.Language"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Film fm = (Film) session.getAttribute("fm");
		ArrayList<Language> lanlist = new ArrayList();
		ArrayList listname = new ArrayList();
		lanlist = (ArrayList) session.getAttribute("lanlist");
		listname =(ArrayList) session.getAttribute("listname");
	%>
	<form action="<%=request.getContextPath()%>/UpdateServlet"
		method="post">
		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td>film_id</td>
				<td>title</td>
				<td>description</td>
				<td>language</td>
			</tr>
			<tr>
				<td><input type="text" value="<%=fm.getFilm_id()%>"
					name="film_id" readonly="readonly" /></td>
				<td><input type="text" value="<%=fm.getTitle()%>" name="title" /></td>
				<td><input type="text" value="<%=fm.getDescription()%>"
					name="description" /></td>
				<!-- <td><input type="text" value="<%=fm.getLanguage_name()%>"
					name="language_name" /></td> -->
					
					<td> <select name="language_name">
					<%for(int i=0;i<listname.size();i++){ %>
					    <option><%=listname.get(i)%></option>
					    <%} %>
					</select>
					</td>
			</tr>
			<th></th>
			<th></th>
			<th><input type="submit" value="提交" /></th>
			<th><input type="reset" name="reset" /></th>
			<!--  -->

	</form>

</body>
</html>