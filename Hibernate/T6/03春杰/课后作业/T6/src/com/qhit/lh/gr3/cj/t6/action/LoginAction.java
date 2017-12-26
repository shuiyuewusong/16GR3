package com.qhit.lh.gr3.cj.t6.action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.cj.t6.bean.User;
import com.qhit.lh.gr3.cj.t6.service.BaseService;
import com.qhit.lh.gr3.cj.t6.service.impl.BaseServiceImpl;


/**
 * @author 03春杰
 * TODO
 * 2017年12月20日上午11:39:16	
 */
public class LoginAction extends ActionSupport{
	private User user;
	private BaseService baseService = new BaseServiceImpl();

	public void validate() {
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
		List<User> listUser = baseService.AccordingToUserQueryPassWord(user.getUname());
		
		if(listUser != null && listUser.size() == 1 ){
			if (listUser.get(0).getUpwd().equals(user.getUpwd())) {
				return "loginSuccess";
			}
		}
		super.addFieldError("user.uname", getText("uname.empty"));
		super.addFieldError("user.upwd", getText("password.empty"));
		return "loginFaile";
		
		
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
