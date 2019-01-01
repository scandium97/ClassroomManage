<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ClassRoom Management System</title>
</head>
<body>
	<h1>Welcome to the ClassRoom Management System</h1>
	<p>如果你还没有注册，请点击下面的注册按钮</p>
	<form action="Login" method='POST'>
		<p>用户名 <input type="text" name="uid"></p>
		<p>密码&nbsp;&nbsp;&nbsp;&nbsp; <input type="password" name="password"></p>
		<p><input type="submit" value="登录"></p>
	</form>
	<p><a href='reg.jsp'>注册</a></p>
</body>
</html>