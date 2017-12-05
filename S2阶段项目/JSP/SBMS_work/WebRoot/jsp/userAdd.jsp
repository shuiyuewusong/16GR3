<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'userAdd.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function checkit() {
		//判断是否是数字的正则表达式
		return true;
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>

		</div>
		<form id="form1" method="post" action="Um?cmd=uploadPic" enctype="multipart/form-data">
			<div class="content">
				<table class="box">
					<font color="red"></font>
					<tr>
						<td class="field">用户姓名：</td>
						<td><input type="text" name="userName" class="text"
							id="userName" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户密码：</td>
						<td>
							<input type="password" name="userPassword" class="text" id="userPassword" /> 
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
							<td><input type="password" name="userPassword2" class="text" id="userPassword2" /> 
							<font color="red">*</font>
						</td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td><select name="userSex" id="userSex">
								<option selected="selected" value="F">女</option>
								<option value="M">男</option>
						</select></td>
					</tr>

					<tr>
						<td class="field">用户年龄：</td>
						<td><input type="text" name="userAge" class="text"
							id="userAge" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><input type="text" name="telephone" class="text"
							id="telephone" /> <font color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td>
							<textarea name="address" id="address" class="text"
								cols="45" rows="5">
							</textarea>
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>

						<td>
							<input type="radio" name="type" id="type" value="1" checked="checked" />普通用户 
							<input type="radio" name="type" id="type" value="0" />经理
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户头像：</td>
						<td>
							<input type="file" name="pic" id="pic">
							<font color="red">*允许图片的格式为:png,jpg,JPEG,gif;大小不超过5M</font>
						</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="button" name="button" id="button" value="数据提交"
					class="input-button" onclick="checkForm();" /> 
				<input type="button" name="button"
					id="button" onclick="window.location='user.do';" value="返回"
					class="input-button" />
			</div>

		</form>
	</div>
	<script type="text/javascript">
		function checkForm() {
			var form1 = document.getElementById("form1");
			var userPassword = document.getElementById("userPassword").value;
			var userPassword2 = document.getElementById("userPassword2").value;
			//TODO 
			if(
					check("userName") && 
					check("userPassword") &&
					check("userPassword2") &&
					check("userSex") &&
					check("userAge") &&
					check("telephone") &&
					check("address") &&
					check("type") &&
					check("pic")
				){
				
				if(userPassword == userPassword2){
					//密码验证通过，然后进行表单提交
					form1.submit();
				}else{
					alert("两次密码不一致，请重新输入!");
				}
				
			}else{
				alert("请填写完整的信息!");
			}
			
		}
		
		//验证控件是否为空的
		function check(id) {
			var suiyi = document.getElementById(id).value;
			if(suiyi != null && suiyi != ""){
				return true;
			}else{
				return false;
			}
		}
	</script>
</body>
</html>