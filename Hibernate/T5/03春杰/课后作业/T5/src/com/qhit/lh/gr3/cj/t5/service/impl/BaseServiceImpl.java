package com.qhit.lh.gr3.cj.t5.service.impl;



import java.util.List;

import com.qhit.lh.gr3.cj.t5.dao.BaseDao;
import com.qhit.lh.gr3.cj.t5.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.cj.t5.service.BaseService;






/**
 * @author 03春杰
 * TODO
 * 2017年12月11日上午10:07:25	
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.service.BaseService#add(java.lang.Object)
	 */
	@Override
	public void add(Object object) {
		baseDao.add(object);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.service.BaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object object) {
		baseDao.delete(object);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Object object) {
		baseDao.update(object);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.hb_t1.service.BaseService#query(java.lang.String)
	 */
	@Override
	public List<Object> query(String fromtable) {
		return baseDao.query(fromtable);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.cj.t2.service.BaseService#getObjectById(java.lang.Object, int)
	 */
	@Override
	public Object getObjectById(Class clazz, int id) {
		// TODO Auto-generated method stub
		return baseDao.getObjectById(clazz, id);
	}

}
