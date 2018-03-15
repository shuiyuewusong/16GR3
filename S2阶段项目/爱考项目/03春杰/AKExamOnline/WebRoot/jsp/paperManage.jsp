<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>试卷管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jQuery.js"></script>
<style type="text/css">
span {
	display: none;
}

th {
	background-color: #666;
}

td {
	text-align: center;
}

#marginTop {
	margin-top: 20px;
}

.margRight {
	margin-right: 10px;
}
</style>
</head>
<script type="text/javascript">
function showRanCrePaper() {
	var width = (screen.width - 600) / 2;
	var height = (screen.height - 400) / 2;
	var dialog = window
			.open(
					"jsp/createPaperRandom.jsp",
					"window",
					"width=600px,height=400px,top="
							+ height
							+ ", left="
							+ width
							+ ", toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
	//轮询窗口是否关闭,关闭的话刷新数据
	setInterval(function(){
		if(dialog != null && dialog.closed){
			window.location.reload(true);
		}
	}, 800);
}
function showSelectCrePaper() {
	var width = (screen.width - 700) / 2;
	var height = (screen.height - 600) / 2;
	var dialog = window
			.open(
					"jsp/createChoosePaper.jsp",
					"window",
					"width=700px,height=600px,top="
							+ height
							+ ", left="
							+ width
							+ ", toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
	//轮询窗口是否关闭,关闭的话刷新数据
	setInterval(function(){
		if(dialog != null && dialog.closed){
			window.location.reload(true);
		}
	}, 800);
}
function showStartExam(pid,ptime) {
	var width = (screen.width - 600) / 2;
	var height = (screen.height - 400) / 2;
	var dialog = window
			.open(
					"clazz/clazz_getClazzList?pid="+pid+"&ptime="+ptime,
					"window",
					"width=600px,height=400px,top="
							+ height
							+ ", left="
							+ width
							+ ", toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
	//轮询窗口是否关闭,关闭的话刷新数据
	setInterval(function(){
		if(dialog != null && dialog.closed){
			window.location.href="${basePath}paper/paper_getPaperList";
		}
	}, 800);
}

function getCourses() {
	var url = "${basePath}course/course_getCourses2Json.action";
	var majorValue = $("#majorSelect").val();
	var stageValue = $("#stageSelect").val();
	 $.getJSON(url,
			 {
		 		'course.major':majorValue,
		 		'course.stage':stageValue
			 },
			 function(data){
		    	//alert(JSON.stringify(data));
		    	$("#csId").empty();
		    	$("#csId").append("<option value=''>请选择</option>");
		    	$.each(data, function(i,course){
		    		$("#csId").append("<option value='"+course.csId+"'>"+course.csName+"</option>");
		    	});
			}
	);
}
</script>
<body>
	<div>
		<h3 align="center">试卷列表</h3>
		<form action="paper/paper_getPaperList" method="post">
			方向:
			<s:select id="majorSelect"
				list="#{'':'请选择','SCME':'SCME','SCCE':'SCCE'}" name="majorSelect"
				onchange="getCourses()" />
			阶段:
			<s:select id="stageSelect"
				list="#{'':'请选择','G1':'G1','G2':'G2','G3':'G3'}" name="stageSelect"
				onchange="getCourses()" />
			考试科目:
			<s:select list="{}" name="course.csId" id="csId"
				listKey="csId" listValue="csName" headerKey="" headerValue="请选择" />
			<%-- <select name="csId" class="margRight">
				<option value="">请选择</option>
				<option value="1">计算机基础</option>
			</select> --%>
			考试类型:
			<s:select list="#{'':'请选择','笔试':'笔试','机试':'机试'}" name="paper.ptype"></s:select>
			状态:
			<s:select list="#{'':'请选择','未开考':'未开考','考试中':'考试中','考试结束':'考试结束'}"
				name="paper.pstate"></s:select>
			<input type="submit" value="查询" class="margRight">
		</form>
		<div style="margin-top: 20px;">
			<button onclick="javascript:showRanCrePaper();" class="margRight">随机组卷</button>
			<button onclick="javascript:showSelectCrePaper();" class="margRight">选题组卷</button>
			<button onclick="" class="margRight">上机考试</button>
		</div>
	</div>
	<div>
		<fieldset id="marginTop">
			<table width="100%" align="center" id="marginTop" border="0.5"
				bordercolor="#eee" cellspacing="1">
				<tr>
					<th><font color="white">序号</font></th>
					<th><font color="white">类型</font></th>
					<th><font color="white">科目</font></th>
					<th><font color="white">标题</font></th>
					<th><font color="white">考试班级</font></th>
					<th><font color="white">考试时长(分钟)</font></th>
					<th><font color="white">状态</font></th>
					<th><font color="white">操作</font></th>
				</tr>
				<s:iterator value="pageBean.Items" var="paperInfo" status="status">
					<tr>
						<td>${status.count }</td>
						<td>${paperInfo.ptype }</td>
						<td>[${paperInfo.course.major }&nbsp;${paperInfo.course.stage }]<br>${paperInfo.course.csName }</td>
						<td>${paperInfo.pname }</td>
						<td><s:iterator value="#paperInfo.paperClasses" var="paperClass">
								${paperClass.classInfo.cname }、
							</s:iterator></td>
						<td>${paperInfo.ptime }</td>
						<td><s:if test="#paperInfo.pstate == '未开考'">
								<font color="red">${paperInfo.pstate }</font>
							</s:if> <s:elseif test="#paperInfo.pstate == '考试中'">
								<font color="green">${paperInfo.pstate }</font>
							</s:elseif> <s:else>
								<font color="gray">${paperInfo.pstate }</font>
							</s:else></td>
						<!-- TODO 根据状态显示不同的操作-->
						<td><s:if test="#paperInfo.pstate == '未开考'">
								<a href="javascript:alert('不实现')">删除</a>
								<a href="javascript:showStartExam(${paperInfo.pid },${paperInfo.ptime })">开始考试</a>
							</s:if> <s:elseif test="#paperInfo.pstate == '考试中'">
								<a href="paper/paper_endExam?paper.pid=${paperInfo.pid }">结束考试</a>
							</s:elseif> <s:else>
								<a href="javascript:alert('同成绩管理！')">查看成绩</a>
							</s:else> <a href="javascript:alert('同成绩管理！')">查看试卷</a></td>
					</tr>
				</s:iterator>
			</table>

			<div align="right" id="marginTop">
				第${pageBean.currentIndex }页， 共${pageBean.totalPage }页&nbsp;&nbsp; <a
					href="paper/paper_getPaperList?course.csId=${course.csId }&paper.ptype=${paper.ptype}&paper.pstate=${paper.pstate }&pageIndex=1">首页</a>&nbsp;
				<a
					href="paper/paper_getPaperList?course.csId=${course.csId }&paper.ptype=${paper.ptype}&paper.pstate=${paper.pstate }&pageIndex=${pageBean.preIndex }">上一页</a>&nbsp;
				<a
					href="paper/paper_getPaperList?course.csId=${course.csId }&paper.ptype=${paper.ptype}&paper.pstate=${paper.pstate }&pageIndex=${pageBean.nextIndex }">下一页</a>&nbsp;
				<a
					href="paper/paper_getPaperList?course.csId=${course.csId }&paper.ptype=${paper.ptype}&paper.pstate=${paper.pstate }&pageIndex=${pageBean.totalPage }">末页</a>
			</div>
		</fieldset>
	</div>
</body>
</html>
