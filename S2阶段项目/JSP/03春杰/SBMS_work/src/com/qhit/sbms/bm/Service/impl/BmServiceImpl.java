package com.qhit.sbms.bm.Service.impl;



import java.util.List;

import com.qhit.sbms.bm.DAO.impl.AccountDaoImpl;
import com.qhit.sbms.bm.Service.BmService;
import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.gm.Bean.Goods;



/**
 * 
 * 2017年11月13日
 */
public class BmServiceImpl implements BmService{

	@Override
	public PageBean getPageBean(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().getPageBean(pageBean);
	}

	@Override
	public int addAccount(Goods goods, int businessNum, int providerId,
			int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().addAccount(goods, businessNum, providerId, isPayed);
	}

	@Override
	public PageBean getPageBeanByParam(List<String> wheres, List<String> values) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().getPageBeanByParam(wheres, values);
	}

	@Override
	public int deleteAccountById(int accountId) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().deleteAccountById(accountId);
	}

	@Override
	public int upDateAccountById(int accountId, int providerId, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().upDateAccountById(accountId, providerId, isPayed);
	}

}
