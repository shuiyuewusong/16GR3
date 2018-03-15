package com.qhit.lh.gr3.cj.exam.sjgl.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qhit.lh.gr3.cj.exam.common.bean.PageBean;
import com.qhit.lh.gr3.cj.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.cj.exam.sjgl.bean.PaperClass;

public interface PaperDao {
	
	/**
	 * @param paper
	 */
	public void createByChoose(Paper paper);
	
	/**
	 * @param paperClasses
	 */
	public void startExam(List<PaperClass> paperClasses);
	
	/**
	 * @param paper
	 * 结束考试
	 */
	public void updateExam(Paper paper,String state);
	
	/**
	 * @param paper
	 * 随机组卷
	 */
	public void createPaperRandom(Paper paper);

	/**
	 * @param parameter
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);
}
