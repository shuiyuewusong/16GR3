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

<title>开始考试</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<style type="text/css">
input {
	margin: 10px;
}
table{
	background-color: black;
}
td{
	padding:5px 10px;
	text-align: center;
	background-color: white;
}
</style>
</head>
<script type="text/javascript">

function addRows() {
	//创建第一个td
	var $tdClass = $("<td>"+
			"<input type='hidden' class='pid' value='"+${param.pid }+"'>"+
			"<select>"+
				"<s:iterator value='listClazz' var='clazz'>"+
						"<option value='${clazz.ccode }'>${clazz.cname }</option>"+
					"</s:iterator>"+
				"</select>"+
			"</td>");
	//创建第二个td
	var $tdDate = $("<td>"+
			"<input type='hidden' class='endTime'>"+
			"<input type='text' class='Wdate' onfocus='WdatePicker({skin:\"whyGreen\",dateFmt: \"yyyy-MM-dd HH:mm\",lang:\"zh-cn\", minDate: \"%y-%M-%d 08:00}\" })' onchange=\"getEndDate(this)\"/>"+
			"</td>");
	//创建第三个td
	var $tdDelete = $("<td>"+
			"<input type='button' value='删除'>"+
			"</td>");
	
	$("<tr></tr>")
	.append($tdClass)
    .append($tdDate)
    .append($tdDelete)
    .appendTo("#tab_exam")
    .find("input[value=删除]")
    .click(function() {
    	deleteRow(this);
    });
	updateTr();
}

function deleteRow(_this) {
	 var $trNode = $(_this).parent().parent();
     $trNode.remove();
     updateTr();
}
//根据得到的行对象得到所在的行数
function updateTr() {
	$("tr").each(function(index,element){
		$($(".pid").get(index)).attr("name","paperClasses["+index+"].pid");
		$($("select").get(index)).attr("name","paperClasses["+index+"].ccode");
		$($(".Wdate").get(index)).attr("name","paperClasses["+index+"].examDate");
		$($(".endTime").get(index)).attr("name","paperClasses["+index+"].endDate");
	});
}

function getEndDate(_this) {
	//当前试卷的考试时间
	var ptime = ${param.ptime};
	//当前事件源的日期字符串
	var startTime = _this.value;
	//把字符串转换成date对象
	var date = new Date(startTime);
	//获取结束时间
	date.setMinutes(date.getMinutes() + ptime);
	//获取当前事件源上一个兄弟节点的元素
	//var endDateNode = _this.previousSbiling;
	var $endDateNode = $(_this).prev();
	//设置value为格式化后的日期时间
	$endDateNode.attr("value",date.Format("yyyy-MM-dd HH:mm"));
}
</script>
<body>
	<form action="paper/paper_startExam" method="post">
		<div align="center">
			<input type="hidden" name="paper.pid" value="${param.pid }">
			<input type="submit" value="开始考试"> <input type="reset"
				value="取消"> <br> <font>请选择参加考试的班级及开考时间</font>
		</div>
		<table id="tab_exam" align="center" cellspacing="1px" >
			<tr>
				<td>班级</td>
				<td>开考时间</td>
				<td><input type="button" value="添加" onclick="addRows()"></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" class="pid" name="paperClasses[0].pid" value="${param.pid }">
					<select name="paperClasses[0].ccode">
						<s:iterator value="listClazz" var="clazz">
							<option value="${clazz.ccode }">${clazz.cname }</option>
						</s:iterator>
					</select>
				</td>
				<td>
					<input type='hidden' class='endTime' name="paperClasses[0].endDate">
					<input type='text' class="Wdate" name='paperClasses[0].examDate' onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm',lang:'zh-cn', minDate: '%y-%M-%d 08:00}' })" onchange="getEndDate(this)"/>
				</td>
				<td>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
