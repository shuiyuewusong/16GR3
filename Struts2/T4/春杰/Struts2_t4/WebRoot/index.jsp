<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	<s:form action="user/addUser"  method="post">
	<s:textfield label="用户名" name="user.uname" required="true" ></s:textfield>
		<s:password label="密码" name="user.upwd" required="true" ></s:password>
		<s:checkboxlist label="爱好" list="{'吃','喝','玩','乐'}" name="user.like" value="'吃'"></s:checkboxlist>
		<s:select label="学历" list="{'初中','高中','大专','本科','研究生'}" size="1" value="'大专'" name="user.education"></s:select>
		<s:radio label="性别" list="#{1:'男',0:'女'}" name="user.sex" value="0"></s:radio>
		<s:submit value="注册"></s:submit>
	</s:form>
  </body>
</html>
