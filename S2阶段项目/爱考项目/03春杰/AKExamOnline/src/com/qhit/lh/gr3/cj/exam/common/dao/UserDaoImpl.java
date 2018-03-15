/**
 * 
 */
package com.qhit.lh.gr3.cj.exam.common.dao;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.gr3.cj.exam.common.bean.User;

/**类名:UserDaoImpl
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "select user from User user "
				+ "where user.name = ? and "
				+ "user.pwd = ? and "
				+ "user.role = ?";
		Query query =  getSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		
		List<User> list = query.list();
		
		if(list != null && list.size() == 1){
			//登录成功
			return list.get(0);
		}
		return null;
	}

}
