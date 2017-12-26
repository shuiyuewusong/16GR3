<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="login.title"></s:text></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<s:form action="LoginUser" method="post">
		<s:textfield key="label.uname" name="user.uname" required="true"></s:textfield>
		<s:password key="label.upsw" name="user.upwd" required="true"></s:password>
		<s:submit key="label.login"></s:submit>
	</s:form>

	<s:url id="localEN" namespace="/" action="local">
		<s:param name="request_locale">en_US</s:param>
	</s:url>
	<s:url id="localzhCN" namespace="/" action="local">
		<s:param name="request_locale">zh_CN</s:param>
	</s:url>
	<s:a href="%{localEN}">English</s:a>
	<s:a href="%{localzhCN}">中文</s:a>

</body>
</html>
