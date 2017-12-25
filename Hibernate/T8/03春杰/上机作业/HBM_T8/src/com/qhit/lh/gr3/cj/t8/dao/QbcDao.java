
package com.qhit.lh.gr3.cj.t8.dao;

import java.util.List;

/**
 * @author 03春杰
 * TODO
 * 2017年12月25日上午10:01:56	
 */
public interface QbcDao {
	

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
