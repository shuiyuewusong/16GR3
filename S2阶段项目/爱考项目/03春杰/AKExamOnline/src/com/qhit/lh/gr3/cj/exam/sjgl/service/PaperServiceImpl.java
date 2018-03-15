package com.qhit.lh.gr3.cj.exam.sjgl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qhit.lh.gr3.cj.exam.common.bean.PageBean;
import com.qhit.lh.gr3.cj.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.cj.exam.sjgl.bean.PaperClass;
import com.qhit.lh.gr3.cj.exam.sjgl.dao.PaperDao;
import com.qhit.lh.gr3.cj.exam.sjgl.dao.PaperDaoImpl;

public class PaperServiceImpl implements PaperService {
	private PaperDao paperDao = new PaperDaoImpl();

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		return paperDao.getPaperList(pageBean, parameter, pageIndex);
	}

	@Override
	public void createPaperRandom(Paper paper) {
		paperDao.createPaperRandom(paper);
	}

	@Override
	public void endExam(Paper paper) {
		paperDao.updateExam(paper,"考试结束");
	}

	@Override
	public void startExam(List<PaperClass> paperClasses,Paper paper) {
		paperDao.startExam(paperClasses);
		paperDao.updateExam(paper, "考试中");
	}

	@Override
	public void createByChoose(Paper paper) {
		paperDao.createByChoose(paper);
	}

}
