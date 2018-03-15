/**
 * 
 */
package com.qhit.lh.gr3.cj.exam.common.dao;

import com.qhit.lh.gr3.cj.exam.common.bean.User;

/**类名:UserDao
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public interface UserDao {
	/**
	 * @param user
	 * @return
	 * 登录
	 */
	public User login(User user);
}
