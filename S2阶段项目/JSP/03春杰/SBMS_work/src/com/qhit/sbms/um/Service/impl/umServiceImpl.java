package com.qhit.sbms.um.Service.impl;



import com.qhit.sbms.common.bean.PageBean;

import com.qhit.sbms.um.Bean.User;
import com.qhit.sbms.um.Dao.impl.umDaoImpl;
import com.qhit.sbms.um.Service.umService;

public class umServiceImpl implements umService {

	public User doLogin(String userName, String userPassword) {
		
		return new umDaoImpl().doLogin(userName, userPassword);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new umDaoImpl().addUser(user);
	}

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new umDaoImpl().getPageBean(pageBean);
	}

}
