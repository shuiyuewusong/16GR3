package com.qhit.sbms.sm.Service.impl;



import java.util.List;

import com.qhit.sbms.bm.DAO.impl.AccountDaoImpl;
import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.sm.Bean.Provider;
import com.qhit.sbms.sm.Dao.impl.ProviderDaoImpl;
import com.qhit.sbms.sm.Service.ProviderService;



public class ProviderServiceImpl implements ProviderService {

	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getAllProvider();
	}

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getPageBean(pageBean);
	}



}
