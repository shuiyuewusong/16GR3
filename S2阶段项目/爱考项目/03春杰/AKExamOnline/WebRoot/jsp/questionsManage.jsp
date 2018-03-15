<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'questionsManage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.group {
	text-align: center;
	width: 200px;
	height: 60px;
	margin: 10px 10px;
	float: left;
	border: solid 1px black;
	padding: 5px;
}
</style>
</head>

<body>
	<!-- 
		1，theme='simple' 不使用主题，水平排列 
		2，s:if判断记录当前查询条件
	-->
	<s:form action="/question/question_getCourseInfo" method="post" theme="simple">
		<s:select name="major" list="{'SCME','SCCE'}"></s:select>
		<s:select name="stage" list="{'G1','G2','G3'}"></s:select>
		<s:submit value="查询"></s:submit>
	</s:form>
	
	<s:iterator value="listCourses" var="course">
		<div align="center" class="group">
			${course.csName }&nbsp;&nbsp;${course.stage }
			<br />
			<a href="jsp/developing.jsp" target="manFrame">
				机试题:
				<s:property value="#course.machineQuestions.size()"/>
			</a>
			<br>
			<a href="question/question_getWrittenList?course.csId=${course.csId }&course.csName=${course.csName}" target="manFrame">
				笔试题:<s:property value="#course.writtenQuestions.size()"/>
			</a>
		</div>
	</s:iterator>
</body>
</html>
