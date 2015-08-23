<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String flag =session.getAttribute("flag").toString(); 
if(flag.equals("login_success")){
%>
登录成功！
<% }else {%>
登录失败
<%} %>

<a href="<%= request.getContextPath() %>/ShowServlet">显示所有信息</a>
<a href="<%=request.getContextPath()%>/GetLanguageServlet" >增加信息</a>
</body>
</html>