<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form action="user" method="post">
		用户：<input type="text" name="users.uname"><br /> 
		密码：<input type="password" name="users.upwd"><br /> 
		年龄：<input type="text" name="users.age"><br /> 
		生日：<input type="text" name="users.birthday"><br /> 
		性别：<input type="text" name="users.sex"><br /> 
		地址：<input type="text" name="users.address"><br />
		电话：<input type="text" name="users.telphone"><br />
		<input type="submit" value="注册" >


	</form>
</body>
</html>
