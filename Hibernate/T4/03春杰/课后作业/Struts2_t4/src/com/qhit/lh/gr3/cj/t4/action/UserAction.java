package com.qhit.lh.gr3.cj.t4.action;



import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.cj.t4.bean.User;
import com.qhit.lh.gr3.cj.t4.bean.Users;
import com.qhit.lh.gr3.cj.t4.service.BaseService;
import com.qhit.lh.gr3.cj.t4.service.impl.BaseServiceImpl;


/**
 * @author 03春杰
 * TODO
 * 2017年12月18日上午10:41:15	
 */
public class UserAction extends ActionSupport {
	private Users users;



	
	public String addUser() throws Exception {
		
		User user = new User();

		// TODO 注册
		System.out.println("进入addUser");
		System.out.println(users.getUname());
		user.setUname(users.getUname());
		user.setUpwd(users.getUpwd());
		user.setEducation(users.getEducation());
		user.setSex(users.getSex());
		int i = users.getLike().size();
		if (i>0) {
			user.setLike1(users.getLike().get(0));
			if (i>1) {
				user.setLike2(users.getLike().get(1));
				if (i>2) {
					user.setLike3(users.getLike().get(2));
					if (i>3) {
						user.setLike4(users.getLike().get(3));
					}
				}
			}
		}
		
		BaseService baseService = new BaseServiceImpl();
		 baseService.add(user);
			return "success";
	}




	public Users getUsers() {
		return users;
	}




	public void setUsers(Users users) {
		this.users = users;
	}





	



}
