package com.qhit.sbms.common.service.impl;



import java.util.List;

import com.qhit.sbms.common.dao.impl.CommonDaoImpl;
import com.qhit.sbms.common.service.CommonService;



/**
 * @author admin
 * 2017年11月14日
 */
public class CommonServiceImpl implements CommonService {

	@Override
	public int getCount(String tableName, List<String> wheres,
			List<String> values) {
		// TODO Auto-generated method stub
		return new CommonDaoImpl().getCount(tableName, wheres, values);
	}

}
