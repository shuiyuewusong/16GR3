package com.qhit.sbms.um.Service;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.um.Bean.User;

public interface umService {
	/**
	 * @param pageBean
	 * @return
	 * 分页的业务
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
	 * 登录的业务
	 */
	public  User doLogin(String userName, String userPassword) ;
}
