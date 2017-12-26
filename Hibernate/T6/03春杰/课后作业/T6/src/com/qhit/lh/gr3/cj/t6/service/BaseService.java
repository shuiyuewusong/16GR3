package com.qhit.lh.gr3.cj.t6.service;

import java.util.List;

import com.qhit.lh.gr3.cj.t6.bean.User;

/**
 * @author 03春杰
 * TODO
 * 2017年12月20日上午9:37:42	
 */
public interface BaseService {
	/**
	 * 
	 * @param object
	 * 添加数据
	 */
	public void add(Object object);
	/**
	 * 
	 * @param object
	 * 删除数据
	 */
	public void delete(Object object);
	/**
	 * 
	 * @param object
	 * 修改数据
	 */
	public void update(Object object);
	/**
	 * 
	 * @param formtable
	 * @return
	 * 查询数据
	 */
	public List<Object> query(String formtable);
	
	/**
	 * @param Object
	 * @param id
	 * @return
	 * 根据id去查
	 */
	@SuppressWarnings("rawtypes")
	public Object getObjectById(Class clazz, int id);
	
	/**
	 * @param uname
	 * @return
	 * 根据用户名查密码
	 */
	public List<User> AccordingToUserQueryPassWord( String uname);
}

