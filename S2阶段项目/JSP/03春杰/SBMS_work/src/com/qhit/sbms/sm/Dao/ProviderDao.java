package com.qhit.sbms.sm.Dao;



import java.util.List;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.sm.Bean.Provider;



public interface ProviderDao {
	/**
	 * @param pageBean
	 * @return
	 * 分页的数据访问
	 */
	public PageBean getPageBean(PageBean pageBean);

	/**
	 * @return
	 */
	public List<Provider> getAllProvider();
}
