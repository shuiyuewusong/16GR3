package com.qhit.lh.gr3.cj.exam.bjgl.service;

import java.util.List;

import com.qhit.lh.gr3.cj.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.cj.exam.bjgl.dao.ClazzDao;
import com.qhit.lh.gr3.cj.exam.bjgl.dao.ClazzDaoImpl;

public class ClazzServiceImpl implements ClazzService {
	private ClazzDao clazzDao = new ClazzDaoImpl();

	@Override
	public List<ClassInfo> getClazzList() {
		return clazzDao.getClazzList();
	}

}
