package com.qhit.t4.action;


import com.opensymphony.xwork2.ActionSupport;
import com.qhit.t4.bean.User;
import com.qhit.t4.service.UserService;
import com.qhit.t4.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport {
	private User user;
	private UserService uService = new UserServiceImpl();
	
	public String addUser() throws Exception {
		// TODO 注册
		int row = uService.addUser(user);
		if(row > 0) {
			return "success";
		}else {
			return "error";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	



}
