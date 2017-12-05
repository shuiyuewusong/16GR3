package com.qhit.sbms.sm.Service;



import java.util.List;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.sm.Bean.Provider;



public interface ProviderService {
	
	/**
	 * @param pageBean
	 * @return
	 * 分页的业务
	 */
	public PageBean getPageBean(PageBean pageBean);

	/**
	 * @return
	 */
	public List<Provider> getAllProvider();
}
