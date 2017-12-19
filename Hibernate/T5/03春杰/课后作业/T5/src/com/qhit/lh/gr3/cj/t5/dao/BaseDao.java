package com.qhit.lh.gr3.cj.t5.dao;



import java.util.List;

/**
 * @author 03春杰
 * TODO
 * 2017年12月11日上午9:41:43	
 */

public interface BaseDao {
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
	public List<Object> query(String fromtable);
	
	/**
	 * @param obj
	 * @param id
	 * @return
	 * 根据id去查
	 */
	public Object getObjectById(Class clazz, int id);


}
