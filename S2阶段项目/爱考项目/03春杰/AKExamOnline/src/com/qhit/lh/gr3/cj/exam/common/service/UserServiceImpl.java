/**
 * 
 */
package com.qhit.lh.gr3.cj.exam.common.service;

import com.qhit.lh.gr3.cj.exam.common.bean.User;
import com.qhit.lh.gr3.cj.exam.common.dao.UserDao;
import com.qhit.lh.gr3.cj.exam.common.dao.UserDaoImpl;

/**类名:UserServiceImpl
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
