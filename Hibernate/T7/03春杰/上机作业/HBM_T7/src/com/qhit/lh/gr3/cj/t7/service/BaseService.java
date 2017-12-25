package com.qhit.lh.gr3.cj.t7.service;

import java.util.List;

import com.qhit.lh.gr3.cj.t7.bean.User;

/**
 * @author 03春杰
 * TODO
 * 2017年12月25日上午9:25:49	
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
	 * @param name
	 * @return
	 * 根据名字模糊查
	 */
	public List<User> getUserByName(String name);
}

