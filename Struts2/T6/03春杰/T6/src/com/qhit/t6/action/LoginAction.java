package com.qhit.t6.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.t6.bean.User;


public class LoginAction extends ActionSupport{
	private User user;

	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(user.getUname())) {
			//有错误--》报告错误消息
			super.addFieldError("user.uname", getText("uname.empty"));
		}
		if("".equals(user.getUpwd())) {
			//有错误--》报告错误消息
			super.addFieldError("user.upwd", getText("password.empty"));
		}
		//数据格式化验证、数据有效性验证：正则表达式（用户名、邮箱、手机号、密码）
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		Matcher matcher = pattern.matcher(user.getUname());
		if(!matcher.matches()) {
			//验证不通过
			super.addFieldError("user.uname", getText("uname.formatError"));
		}
	}

	public String Login() {
		
		return "loginSuccess";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
