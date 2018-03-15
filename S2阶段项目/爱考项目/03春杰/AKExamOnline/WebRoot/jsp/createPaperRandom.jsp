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

<title>随机组卷</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jQuery.js"></script>
<style type="text/css">
tr {
	margin: 10px;
}

td {
	margin: 10px;
}
</style>
<script type="text/javascript">
var radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;

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

//TODO 获取当前科目的最大题目数
function getQuestionMaxNum() {
	var csId = $("#csId").val();
	var url = "${basePath}question/question_getQuestionMax";
	$.getJSON(
		url,
		{
			'writtenQuestion.csId':csId
		},
		function(data){
			radioEasyMax = data.radioEasyMax;
			radioNormalMax = data.radioNormalMax;
			radioDiffMax = data.radioDiffMax;
			cbEasyMax = data.cbEasyMax;
			cbNormalMax = data.cbNormalMax;
			cbDiffMax = data.cbDiffMax;
		}
	);
}

//TODO 更新总题数和每题分数
function getQuestionTotal(i) {
	var ptotalScore = Number($("#ptotalScore").val());
	if(typeof(radioEasyMax)=="undefined"){
		alert("请选择课程！");
		return;
	}
	if(ptotalScore == 0){
		alert("请填写总分数！");
		return;
	}
	//获取随机组卷需要的题目数
	var radioEasy = Number($("#radioEasy").val());
	var radioNormal = Number($("#radioNormal").val());
	var radioDiff = Number($("#radioDiff").val());
	var cbEasy = Number($("#cbEasy").val());
	var cbNormal = Number($("#cbNormal").val());
	var cbDiff = Number($("#cbDiff").val());
	//判断数据库中题目数量是否满足
	switch (i) {
	case 1:
		if(radioEasy > radioEasyMax){
			alert("简单的单选题目数量不足");
			return;
		}
		break;
	case 2:
		if(radioNormal > radioNormalMax){
			alert("一般的单选题目数量不足");
			return;
		}
		break;
	case 3:
		if(radioDiff > radioDiffMax){
			alert("困难的单选题目数量不足");
			return;
		}
		break;
	case 4:
		if(cbEasy > cbEasyMax){
			alert("简单的多选题目数量不足");
			return;
		}
		break;
	case 5:
		if(cbNormal > cbNormalMax){
			alert("一般的多选题目数量不足");
			return;
		}
		break;
	case 6:
		if(cbDiff > cbDiffMax){
			alert("困难的多选题目数量不足");
			return;
		}
		break;
	}
	//计算总题目数
	var qtotal = radioEasy + radioNormal + radioDiff + cbEasy + cbNormal + cbDiff;
	//设置总题目数
	$("#qtotal").val(qtotal);
	//计算每题的分数
	$("#qscore").val((ptotalScore/qtotal).toFixed(2));
}
</script>
</head>

<body>
	<form action="paper/paper_createByRandom" method="post">
		<input type="hidden" name="paper.ptype" value="笔试">
		<input type="hidden" name="paper.pstate" value="未开考">
		<table align="center" width="80%" height="80%">
			<tr>
				<td style="text-align: right;">方向：</td>
				<td>
					<select id="majorSelect" onchange="getCourses()">
						<option value="">请选择</option>
						<option value="SCME">SCME</option>
						<option value="SCCE">SCCE</option>
					</select>
					阶段: 
					<select id="stageSelect" onchange="getCourses()">
						<option value="">请选择</option>
						<option value="G1">G1</option>
						<option value="G2">G2</option>
						<option value="G3">G3</option>
					</select>
					科目: 
					<select name="course.csId" id="csId" onchange="getQuestionMaxNum()">
						<option value="">请选择</option>
					</select>
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">标题：</td>
				<td>
					<input type="text" name="paper.pname" size="45">
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">总分：</td>
				<td><input type="text" id="ptotalScore" name="paper.ptotalScore">分<font
					color="red">*</font></td>
			</tr>
			<tr>
				<td style="text-align: right;">考试时长：</td>
				<td><input type="text" name="paper.ptime">分钟<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">单选题：</td>
				<td>
					简单<input type="text" id="radioEasy" name="radioEasy" size="2" onchange="getQuestionTotal(1)"> 
					一般<input type="text" id="radioNormal" name="radioNormal" size="2" onchange="getQuestionTotal(2)"> 
					困难<input type="text" id="radioDiff" name="radioDiff" size="2" onchange="getQuestionTotal(3)">
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">多选题：</td>
				<td>
					简单<input type="text" id="cbEasy" name="cbEasy" size="2" onchange="getQuestionTotal(4)">
					一般<input type="text" id="cbNormal" name="cbNormal" size="2" onchange="getQuestionTotal(5)"> 
					困难<input type="text" id="cbDiff" name="cbDiff" size="2" onchange="getQuestionTotal(6)">
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">总题数：</td>
				<td><input type="text" id="qtotal" name="paper.qtotal" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="text-align: right;">每题分数：</td>
				<td><input type="text" id="qscore" name="paper.qscore" readonly="readonly"></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="2">
					<input type="submit" value="创建试卷"> 
					<input type="reset" value="取消">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
