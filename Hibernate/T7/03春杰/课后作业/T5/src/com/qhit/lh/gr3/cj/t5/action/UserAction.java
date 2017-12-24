package com.qhit.lh.gr3.cj.t5.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.cj.t5.bean.User;
import com.qhit.lh.gr3.cj.t5.service.BaseService;
import com.qhit.lh.gr3.cj.t5.service.impl.BaseServiceImpl;

/**
 * @author 03春杰 
 * TODO 2017年12月19日下午7:38:16
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private User user;
	private List<User> users = new ArrayList<User>();
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * @return 添加用户
	 */
	public String add() {
		try {
			// uService.addUser(user);
			baseService.add(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}

	/**
	 * @return 删除用户
	 */
	public String delete() {
		try {
			// uService.deleteUser(user);
			baseService.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}

	/**
	 * @return 先查询当前用户信息，再跳转到修改页面
	 */
	public String toUpdate() {
		try {
			// user = uService.getUserById(user);
			user = (User) baseService.getObjectById(User.class, user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toUpdate";
	}

	/**
	 * @return 修改用户信息
	 */
	public String update() {
		try {
			// uService.updateUser(user);
			baseService.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "toAll";
	}

	/**
	 * @return 查询所有的用户
	 */
	public String getAll() {
		try {
			// users = uService.getAllUser();
			List<Object> list = baseService.query("from User");
			for (Object object : list) {
				User user = (User) object;
				System.out.println(user.toString());
				users.add(user);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "listUser";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
