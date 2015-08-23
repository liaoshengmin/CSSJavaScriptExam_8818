<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<link href="style.css" type="text/css" rel="stylesheet" />
<script src="jquery-2.1.4.min.js"></script>
<script src="bootstrap.min.js"></script>
</head>
<body>
	<%
		ArrayList listname1 = new ArrayList();
		listname1 = (ArrayList) session.getAttribute("listname1");
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
				<div id="add_right_head">
					<h3>创建Customer</h3>

				</div>
				<hr>
				<form action="<%=request.getContextPath()%>/AddServlet"
					method="post">
					<div class="row" id="add_input">
						<div class="col-lg-1">
							FirstName<a style="color: red">*</a>：
						</div>
						<div class="col-lg-11">
							<input type="text" name="fname" />
						</div>
						<div class="col-md-1">
							LastName<a style="color: red">*</a>：
						</div>
						<div class="col-md-11">
							<input type="text" name="lname" />
						</div>
						<div class="col-md-1">Email：</div>
						<div class="col-md-11">
							<input type="text" name="email" />
						</div>
						<div class="col-md-1">
							Address<a style="color: red">*</a>：
						</div>
						<div class="col-md-11">
							<select name="addressname">
								<%
									for (int i = 0; i < listname1.size(); i++) {
								%>
								<option><%=listname1.get(i)%></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="col-md-2">
							<input type="submit" class="btn btn-info" value="新建"> <input
								type="reset" class="btn btn-info" value="取消">
						</div>

					</div>
				</form>



			</div>
		</div>







	</div>

</body>
</html>