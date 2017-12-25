package com.qhit.lh.gr3.cj.t8.service;

import java.util.List;

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
	 * @param clazz
	 * @param string1
	 * @param string2
	 * @return
	 * 相等判断
	 */
	@SuppressWarnings("rawtypes")
	public List<Object> getObjectByEq(Class clazz,String string1 ,String string2);
	
	/**
	 * @param clazz
	 * @param string1
	 * @param string2
	 * @return
	 * 模糊查询
	 */
	@SuppressWarnings("rawtypes")
	public List<Object> getObjectByLike(Class clazz,String string1 ,Object string2);
	
	/**
	 * @param clazz
	 * @param string1
	 * @param string2
	 * @return
	 * 模糊查询
	 */
	@SuppressWarnings("rawtypes")
	public List<Object[]> getObjectByLikeAndProjections(Class clazz,String string1 ,String string2,List<String> list);
}

