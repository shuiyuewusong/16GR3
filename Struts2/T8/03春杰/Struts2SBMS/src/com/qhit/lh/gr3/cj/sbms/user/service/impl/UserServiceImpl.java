package com.qhit.lh.gr3.cj.sbms.user.service.impl;


import java.util.List;

import com.qhit.lh.gr3.cj.sbms.user.bean.User;
import com.qhit.lh.gr3.cj.sbms.user.dao.UserDao;
import com.qhit.lh.gr3.cj.sbms.user.dao.impl.UserDaoImpl;
import com.qhit.lh.gr3.cj.sbms.user.service.UserService;

/**
 * @author 03春杰
 * TODO
 * 2017年12月10日下午3:28:52	
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User doLogin(String userName, String userPassword) {
		return userDao.doLogin(userName, userPassword);
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public List<User> getAll() throws Exception {
		return userDao.getAll();
	}

}
