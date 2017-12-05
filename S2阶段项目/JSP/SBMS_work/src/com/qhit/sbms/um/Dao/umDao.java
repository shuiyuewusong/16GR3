package com.qhit.sbms.um.Dao;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.um.Bean.User;

public interface umDao {
	/**
	 * @param pageBean
	 * @return
	 * 分页的数据访问
	 */
	public PageBean getPageBean(PageBean pageBean);
	
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);
	/**
	 * @param userName
	 * @param passWord
	 * @return
	 * 登录的数据访问
	 */
	public User doLogin(String userName, String userPassword);
}
