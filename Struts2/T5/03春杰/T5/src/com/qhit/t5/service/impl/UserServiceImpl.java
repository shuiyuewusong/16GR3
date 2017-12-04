package com.qhit.t5.service.impl;



import java.util.List;

import com.qhit.t5.bean.User;
import com.qhit.t5.dao.UserDao;
import com.qhit.t5.dao.impl.UserDaoImpl;
import com.qhit.t5.service.UserService;



/**
 * @author jayli
 *
 */
public class UserServiceImpl implements UserService {
	//声明一个全局的userdao对象
	private UserDao userDao = new UserDaoImpl(); 


	@Override
	public int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}


	@Override
	public int deleteUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user);
	}


	@Override
	public int updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUser() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getUserById(user);
	}

}
