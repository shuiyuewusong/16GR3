package com.qhit.lh.gr3.cj.exam.tkgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.cj.exam.common.bean.PageBean;
import com.qhit.lh.gr3.cj.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.cj.exam.tkgl.bean.WrittenQuestion;

/**类名:QuestionService
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public interface QuestionService {
	
	/**
	 * @return
	 * 获取试题集合
	 */
	public List<WrittenQuestion> getQuestionsByType(int csId,String qtype,String degree);
	
	/**
	 * @return
	 * 获取题目数
	 */
	public int getQuestionsMax(int csId,String qtype,String degree);

	/**
	 * 题库管理
	 * @param mjId
	 * @param stage
	 * @return
	 * 题库列表
	 */
	public List<Course> getCourseInfo(Map parameter);
	
	/**
	 * @param pageBean
	 * @return
	 * 笔试题列表分页数据
	 */
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, 
			Course course,
			int pageIndex);
	
	/**
	 * @param writtenQuestion
	 * 添加笔试题
	 */
	public void addWrittenQuestion(WrittenQuestion writtenQuestion);
	
	/**
	 * @param writtenQuestion
	 * @return
	 * 根据id查询试题
	 */
	public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion);
	
	/**
	 * @param writtenQuestion
	 * 更新数据
	 */
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion);
	
	/**
	 * @param listWQuestions
	 * 批量导入笔试题
	 */
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions);
}
