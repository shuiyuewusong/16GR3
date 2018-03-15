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
<title>添加试题</title>
<base target="_self" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
.marginLayout {
	margin: 10px;
}

input {
	margin: 5px;
}

td{
	margin: 5px;
	padding: 5px;
}

.textWidth {
	width: 200px;
}
</style>
<script type="text/javascript">
	
	function checkData() {
		var v1 = document.getElementById("optionA");
		var v2 = document.getElementById("optionB");
		var v3 = document.getElementById("optionC");
		var v4 = document.getElementById("optionD");
		var v6 = document.getElementById("chapter");
		if (v1.value != "" && v2.value != "" && v3.value != ""
				&& v4.value != "" && v6.value != "") {
			document.getElementById("formAddQuestion").submit();
		} else {
			alert("请填写完整!");
		}
	}
	
	function changeOptionType() {
		var qtype = document.getElementById("qtype").value;
		var options = document.getElementsByName("writtenQuestion.answer");
		for(i=0;i<options.length;i++){
			if(qtype == "单选"){
				options[i].setAttribute("type", "radio");
			}else{
				options[i].setAttribute("type", "checkbox");
			}
		}
	}
	
	function closeDialog() {
		window.close();
		return true;
	}
</script>

</head>

<body>
	<div class="marginLayout">
		<form action="question/question_addWrittenQuestion" method="post" name="formAddQuestion"
			id="formAddQuestion" onsubmit="closeDialog()">
			<input type="hidden" name="course.csId" value="${param.csId }">
			<input type="hidden" name="course.csName" value="${param.csName }">
			<input type="hidden" name="writtenQuestion.csId" value="${param.csId }">
			<table class="marginLayout">
				<tr>
					<td align="right"><font>科目名称:</font></td>
					<td> ${param.csName } </td>
				</tr>
				<tr>
					<td align="right"><font>题目类型:</font></td>
					<td>
						<select id="qtype" name="writtenQuestion.qtype" onchange="changeOptionType()">
							<option value="单选" selected="selected">单选</option>
							<option value="多选">多选</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right"><font>题目内容:</font></td>
					<td>
						<textarea rows="3" cols="30" name="writtenQuestion.qtitle" id="qTitle"></textarea>
					</td>
				</tr>
				<tr>
					<td align="right"><font>题目选项:</font></td>
					<td>
						<input type="radio" class="options" name="writtenQuestion.answer" value="A" checked="checked">A
						<input class="textWidth" type="text" name="writtenQuestion.optionA" id="optionA">
						<br />
						<input type="radio" class="options" name="writtenQuestion.answer" value="B">B
						<input class="textWidth" type="text" name="writtenQuestion.optionB" id="optionB">
						<br />
						<input type="radio" class="options" name="writtenQuestion.answer" value="C">C
						<input class="textWidth" type="text" name="writtenQuestion.optionC" id="optionC">
						<br />
						<input type="radio" class="options" name="writtenQuestion.answer" value="D">D
						<input class="textWidth" type="text" name="writtenQuestion.optionD" id="optionD">
						<br />
					</td>
				</tr>
				<tr>
					<td align="right"><font>难易程度:</font></td>
					<td>
						<select name="writtenQuestion.degree">
							<option value="简单" selected="selected">简单</option>
							<option value="一般">一般</option>
							<option value="困难">困难</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right"><font>对应章节:</font></td>
					<td>
						<input class="textWidth" type="text" name="writtenQuestion.chapter" id="chapter">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="添加" onclick="checkData()">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
