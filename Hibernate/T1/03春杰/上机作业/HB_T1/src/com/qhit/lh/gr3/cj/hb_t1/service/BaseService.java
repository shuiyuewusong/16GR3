/**
 * 
 */
package com.qhit.lh.gr3.cj.hb_t1.service;

import java.util.List;

/**
 * @author 03春杰
 * TODO
 * 2017年12月11日上午9:42:27	
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
}

