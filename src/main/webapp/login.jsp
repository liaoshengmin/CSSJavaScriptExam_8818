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
<body id="login_body">
<p><h1>8818廖声民</h1></p>
	<div id="login_div_form">
		<form role="form" action="<%=request.getContextPath()%>/LoginServlet"
			method="post" name="LoginForm">
			<div id="form_text">
				<h3>电影租凭管理系统</h3>
			</div>
			<hr>
			<div  id="form_input">
				<div class="col-md-4">用户名：</div>
				<div class="col-md-8">
					<input type="text" name="fname" />
				</div>
				<div class="col-md-4">密码：</div>
				<div class="col-md-8">
					<input type="text" name="password" />
				</div>
				<br>
				<div class="col-md-5"><input type="submit" class="btn btn-info" value="提交"></div>
				
			</div>
			



		</form>



	</div>
</body>
</html>


