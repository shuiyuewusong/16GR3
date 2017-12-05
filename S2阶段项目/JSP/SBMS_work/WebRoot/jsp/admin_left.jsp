<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="frame-bd">
	<ul class="left-menu">
		<li><a href="jsp/admin_bill_list.jsp" target="mainFrame"> <img
				src="images/btn_bill.gif" />
		</a></li>

		<c:if test="${user.type == 0}">
			<li><a href="jsp/providerAdmin.jsp" target="mainFrame"> <img
					src="images/btn_suppliers.gif" />
			</a></li>
			<li><a href="jsp/userAdmin.jsp" target="mainFrame"> <img
					src="images/btn_users.gif" />
			</a></li>
		</c:if>
		<li><a href="Um?cmd=exit"> <img src="images/btn_exit.gif" />
		</a></li>
	</ul>
</body>
</html>

