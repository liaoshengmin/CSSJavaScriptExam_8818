<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.film.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<link href="style.css" type="text/css" rel="stylesheet" />
<script src="jquery-2.1.4.min.js"></script>
<script src="bootstrap.min.js"></script>
<script src="myjs.js"></script>
</head>
<body style="margin:0px;padding:0px">
	<%
		ArrayList<Customer> list = new ArrayList();
		list = (ArrayList) session.getAttribute("list");
	%>
	<div>
		<div id="index_head">
			<button type="button" class="btn btn-info" id="index_head_btn">Admin</button>
		</div>

		<div id="index_left">
			<ul>
				<li><a href="index.jsp"><h3>Customer管理</h3></a></li>
				<li><a href="#"><h3>Film设置</h3></a></li>
			</ul>
		</div>

		<div id="index_right">
			<div>
				<h1>客户管理</h1>
			</div>
			<hr>
			<div>
				<div id="index_right_head">
					<div style="float: left; width: 20%; margin: 0px; padding: 0px;">
						客户列表</div>
					<div style="float: right; width: 80%; margin: 0px; padding: 0px;">
						<a href="<%=request.getContextPath()%>/GetAddressServlet"><button type="button" class="btn btn-info">新建</button></a>
					</div>
				</div>
				<hr>

				<div class="row" id="index_right_info">
					<div class="col-md-1">操作</div>
					<div class="col-md-1">First Name</div>
					<div class="col-md-1">Last Name</div>
					<div class="col-md-3">Address</div>
					<div class="col-md-3">Email</div>
					<div class="col-md-1">CustomerId</div>
					<div class="col-md-2">Last Update</div>

					<%
						for (int i = 0; i < list.size(); i++) {
					%>

					    <div class="col-md-1">
					    <a href="<%=request.getContextPath()%>/DeleteServlet?typeid=<%=list.get(i).getCustomer_id()%>" >删除</a>
					    <a href="<%=request.getContextPath()%>/ShowOneServlet?typeid=<%=list.get(i).getCustomer_id()%>">更新</a>
					    </div>
						<div class="col-md-1"><%=list.get(i).getFirst_name()%></div>
						<div class="col-md-1"><%=list.get(i).getLast_name()%></div>
						<div class="col-md-3"><%=list.get(i).getAddress()%></div>
						<div class="col-md-3"><%=list.get(i).getEmail()%></div>
						<div class="col-md-1"><%=list.get(i).getCustomer_id()%></div>
						<div class="col-md-2"><%=list.get(i).getLast_update()%></div>


					<%
						}
					%>

				</div>

			</div>
		</div>







	</div>

</body>
</html>