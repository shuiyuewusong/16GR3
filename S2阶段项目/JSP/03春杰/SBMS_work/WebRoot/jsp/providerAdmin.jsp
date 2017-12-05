<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
</head>
<body>
	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td>
						<form method="post" action="Sm?cmd=getSm">
					<input name="flag" value="search" type="hidden" > 
	供应商名称：		<input name="providerName" class="input-text" type="text">
					<input value="组 合 查 询" type="submit" class="button">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='providerAdd.html'" type="button"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
						<td width="100"><div class="STYLE1" align="center">联系人</div></td>
						<td width="100"><div class="STYLE1" align="center">电话</div></td>
						<td width="100"><div class="STYLE1" align="center">地址</div></td>
					</tr>
					<c:forEach items="${pageBeanS.data }" var="Provider">
					<tr>
						<td>${Provider.providerId }</td>
						<td>${Provider.providerName }</td>
						<td>${Provider.providerDetail }</td>
						<td>${Provider.contact }</td>
						<td>${Provider.telephone }</td>
						<td>${Provider.address }</td>

						<td>
						<a href="Sm?cmd=del&&accountId=${Provider.providerId }">删除</a></td>
					</tr>
				</c:forEach> 
				</tbody>
			</table>
		</div>
				<form id="form" action="Bm?cmd=getSm">
			<label class="input-button">跳转到</label> <select name="p"
				onchange="getPageBeanByP();">
				<c:forEach var="j" begin="1" end="${pageBeanS.getPagetotal()}">
					<c:if test="${pageBeanS.getP() == j}">
						<option selected="selected" value="${j}">第${j}页</option>
					</c:if>
					<c:if test="${pageBeanS.getP() != j}">
						<option value="${j}">第${j}页</option>
					</c:if>
				</c:forEach>
			</select> <a class="input-button"
				href="Sm?cmd=getSm&p=${pageBeanS.p - 1 }">上一页</a> <a
				class="input-button"
				href="Sm?cmd=getSm&p=${pageBeanS.p + 1 }">下一页</a>
		</form>
	</div>
</body>
</html>
