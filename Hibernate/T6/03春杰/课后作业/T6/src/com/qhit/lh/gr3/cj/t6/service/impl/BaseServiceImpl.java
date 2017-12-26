package com.qhit.lh.gr3.cj.t6.service.impl;


import java.util.List;

import com.qhit.lh.gr3.cj.t6.bean.User;
import com.qhit.lh.gr3.cj.t6.dao.BaseDao;
import com.qhit.lh.gr3.cj.t6.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.cj.t6.service.BaseService;



/**
 * @author 03春杰
 * TODO
 * 2017年12月20日上午9:37:18	
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();

	
	/* (non-Javadoc)
	 * @see com.qhti.chunjie.service.BaseService#add(java.lang.Object)
	 * 添加数据
	 */
	@Override
	public void add(Object object) {
		baseDao.add(object);
	}
	
	/* (non-Javadoc)
	 * @see com.qhti.chunjie.service.BaseService#delete(java.lang.Object)
	 * 删除数据
	 */
	@Override
	public void delete(Object object) {
		baseDao.delete(object);
	}

	/* (non-Javadoc)
	 * @see com.qhti.chunjie.service.BaseService#update(java.lang.Object)
	 * 修改数据
	 */
	@Override
	public void update(Object object) {
		baseDao.update(object);
	}

	/* (non-Javadoc)
	 * @see com.qhti.chunjie.service.BaseService#query(java.lang.String)
	 * 查询数据
	 */
	@Override
	public List<Object> query(String formtable) {
		return baseDao.query(formtable);
	}

	/* (non-Javadoc)
	 * @see com.qhti.chunjie.service.BaseService#getObjectById(java.lang.Object, int)
	 * 根据id去查
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getObjectById(Class clazz, int id) {
		return baseDao.getObjectById(clazz, id);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.t6.service.BaseService#AccordingToUserQueryPassWord(java.lang.String)
	 */
	@Override
	public List<User> AccordingToUserQueryPassWord(String uname) {
		// TODO Auto-generated method stub
		return baseDao.AccordingToUserQueryPassWord(uname);
	}

}
