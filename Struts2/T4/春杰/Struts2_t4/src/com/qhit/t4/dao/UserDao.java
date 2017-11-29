package com.qhit.t4.dao;

import com.qhit.t4.bean.User;

public interface UserDao {

	/**
	 * @param user
	 * @return
	 * 注册
	 */
	public int addUser(User user);
}
