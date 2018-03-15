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

<title>选题组卷</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jQuery.js"></script>
<style type="text/css">
.container{
           height:400px;
           margin:20px auto auto 20px;
           padding:10px;
           overflow-y:scroll;
       }
.container table{
	background-color: gray;
}
.container table td{
	background-color: white;
	border-spacing: 1px;
	padding: 6px 16px;
}

.qTitle{
	width: 250px;
}
</style>
<script type="text/javascript">
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

var qids = "";
function getQuestions(qid,this) {
	if(this.checked){
		qids+qid+",";
	}
	$("#qids").val(qids);
}

function getQuestions(page) {
	var url = "${basePath}question/question_getQuestionList.action";
	var csId = $("#csId").val();
	
	$("#tab_questions").empty();
	$.getJSON(
			url,
			{
				'course.csId':csId,
				'pageIndex':page
			},
			function(data){
				//数据
				$.each(data.items,function(i){
					var tr = $("<tr></tr>");
					tr.append("<td><input type='checkbox' name='question' onchange='getQuestions(${data.items[i].qid},this)' /></td>");
					tr.append("<td>"+i+"</td>");
					tr.append("<td>"+data.items[i].qtype+"</td>");
					tr.append("<td>"+data.items[i].degree+"</td>");
					tr.append("<td>"+data.items[i].chapter+"</td>");
					tr.append("<td class='qTitle'>"+data.items[i].qtitle+"</td>");
					$("#tab_questions").append(tr);
				});
				//分页
				$("#page").text(data.currentIndex);
				$("#totlePage").text(data.totalPage);
				$("#prePage").attr("href","javascript:getQuestions("+data.preIndex+")");
				$("#nextPage").attr("href","javascript:getQuestions("+data.nextIndex+")");
				$("#lastPage").attr("href","javascript:getQuestions("+data.totalPage+")");
			}
	);
}
</script>
</head>

<body>
	<form action="paper/paper_createByChoose" method="post">
		<input type="hidden" id="qids" name="qids"> 
		<input type="hidden" name="paper.ptype" value="笔试"> 
		<input type="hidden" name="paper.pstate" value="未开考">
		<table align="center">
			<tr>
				<td style="text-align: right;">方向：</td>
				<td colspan="3"><select id="majorSelect" onchange="getCourses()">
						<option value="">请选择</option>
						<option value="SCME">SCME</option>
						<option value="SCCE">SCCE</option>
				</select> 阶段: <select id="stageSelect" onchange="getCourses()">
						<option value="">请选择</option>
						<option value="G1">G1</option>
						<option value="G2">G2</option>
						<option value="G3">G3</option>
				</select> 科目: <select name="course.csId" id="csId" onchange="getQuestions(1)">
						<option value="">请选择</option>
				</select> <font color="red">*</font></td>
			</tr>
			<tr>
				<td style="text-align: right;">标题：</td>
				<td colspan="3">
					<input type="text" name="paper.pname" size="45"> 
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">总分：</td>
				<td>
					<input type="text" id="ptotalScore" name="paper.ptotalScore">分
					<font color="red">*</font>
				</td>
				<td style="text-align: right;">考试时长：</td>
				<td>
					<input type="text" name="paper.ptime">分钟
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">已选题数：</td>
				<td style="min-width: 250px;">
					<input type="text" id="qtotal" name="paper.qtotal" readonly="readonly">
				</td>
				<td style="text-align: right;">每题分数：</td>
				<td>
					<input type="text" id="qscore" name="paper.qscore" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<fieldset class="container" id="container">
						<table id="tab_questions">
							
						</table>
						第<font id="page">1</font>页
						共<font id="totlePage">1</font>页
						<a id="homePage" href='javascript:getQuestions(1)'>首页</a>
						<a id="prePage" href='javascript:getQuestions(1)'>上一页</a>
						<a id="nextPage" href='javascript:getQuestions(1)'>下一页</a>
						<a id="lastPage" href='javascript:getQuestions(1)'>未页</a>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="4">
					<input type="submit" value="创建试卷"> <input type="reset" value="取消">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
