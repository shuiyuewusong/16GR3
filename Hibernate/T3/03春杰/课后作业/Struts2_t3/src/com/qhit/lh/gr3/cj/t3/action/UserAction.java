package com.qhit.lh.gr3.cj.t3.action;

import com.opensymphony.xwork2.Action;
import com.qhit.lh.gr3.cj.t3.bean.Users;
import com.qhit.lh.gr3.cj.t3.service.BaseService;
import com.qhit.lh.gr3.cj.t3.service.impl.BaseServiceImpl;

/**
 * @author 03春杰 TODO 2017年12月18日上午10:51:29
 */
public class UserAction implements Action {
	private Users users;

	@Override
	public String execute() throws Exception {
		BaseService baseService = new BaseServiceImpl();
		baseService.add(users);
		return SUCCESS;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
