package com.qhit.lh.gr3.cj.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.cj.exam.common.bean.PageBean;
import com.qhit.lh.gr3.cj.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.cj.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.cj.exam.sjgl.bean.PaperClass;
import com.qhit.lh.gr3.cj.exam.sjgl.service.PaperService;
import com.qhit.lh.gr3.cj.exam.sjgl.service.PaperServiceImpl;
import com.qhit.lh.gr3.cj.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.cj.exam.tkgl.service.QuestionService;
import com.qhit.lh.gr3.cj.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.gr3.cj.exam.tkgl.utils.RandomQuestionsUtils;

/**类名:PaperAction
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class PaperAction extends ActionSupport {
	private PaperService paperService = new PaperServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private List<Paper> listPapers = new ArrayList<>();
	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定页,初始化为1
	//条件参数
	private Course course;
	private Paper paper;
	private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;
	private List<WrittenQuestion> listRE,listRN,listRD,listCE,listCN,listCD;
	//选题集合
	private String qids;
	//开始考试，班级集合
	private List<PaperClass> paperClasses = new ArrayList<>();
	
	/**
	 * @return
	 * 获取试卷列表
	 */
	public String getPaperList(){
		//设置参数
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("csId", course.getCsId());
		}
		if(paper != null){
			parameter.put("pType", paper.getPtype());
			parameter.put("pState", paper.getPstate());
		}
		//查询题库列表数据
		pageBean = paperService.getPaperList(pageBean, parameter, pageIndex);
		System.out.println(pageBean.getItems().size());
		return "listPaper";
	}
	
	/**
	 * @return
	 * 随机组卷
	 */
	public String createByRandom(){
		System.out.println("1，查询所有的类型的试题");
		//1，查询所有的类型的试题
		listRE = questionService.getQuestionsByType(course.getCsId(), "单选", "简单");
		listRN = questionService.getQuestionsByType(course.getCsId(), "单选", "一般");
		listRD = questionService.getQuestionsByType(course.getCsId(), "单选", "困难");
		listCE = questionService.getQuestionsByType(course.getCsId(), "多选", "简单");
		listCN = questionService.getQuestionsByType(course.getCsId(), "多选", "一般");
		listCD = questionService.getQuestionsByType(course.getCsId(), "多选", "困难");
		//2，随机获取试题集合
		System.out.println("2，随机获取试题集合");
		Set<WrittenQuestion> lisQuestions = RandomQuestionsUtils.randomAllQuestions(
				listRE, listRN, listRD, listCE, listCN, listCD, 
				radioEasy, radioNormal, radioDiff, cbEasy, cbNormal, cbDiff);
		System.out.println("试题数量:"+lisQuestions.size());
		//3，设置试题和试卷的关系
		System.out.println("3，设置试题和试卷的关系");
		paper.setWrittenQuestions(lisQuestions);
		//4，设置课程，添加关系
		paper.setCsId(course.getCsId());
		paper.setCourse(course);
		//5，添加试卷
		System.out.println("4，添加试卷");
		paperService.createPaperRandom(paper);
		
		return "createRandom";
	}
	
	/**
	 * @return
	 * 结束考试
	 */
	public String endExam(){
		paperService.endExam(paper);
		return "endExam";
	}
	
	/**
	 * @return
	 * 开始考试
	 */
	public String startExam(){
		paperService.startExam(paperClasses, paper);
		return "startExam";
	}
	
	
	/**
	 * @return
	 * 选题组卷
	 */
	public String createByChoose() {
		//设置试卷课程的关系
		paper.setCourse(course);
		//从session中获取已选试题集合
		String[] strs = qids.split(",");
		Set<String> setQs = new HashSet<>();
		for(int i=0;i<strs.length;i++) {
			if(strs[i] != null && strs[i] != "") {
				setQs.add(strs[i]);
			}
		}
		Set<WrittenQuestion> questions = new HashSet<>();
		for (String qid : setQs) {
			WrittenQuestion writtenQuestion = new WrittenQuestion();
			writtenQuestion.setQid(Integer.valueOf(qid));
			questions.add(writtenQuestion);
		}
		//设置试卷和试题集合的关系
		paper.setWrittenQuestions(questions);
		//创建试卷
		paperService.createByChoose(paper);
		
		return "createByChoose";
	}

	///////////////////////////////////
	public List<Course> getListCourses() {
		return listCourses;
	}

	public List<Paper> getListPapers() {
		return listPapers;
	}

	public PageBean<Paper> getPageBean() {
		return pageBean;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}

	public void setListPapers(List<Paper> listPapers) {
		this.listPapers = listPapers;
	}

	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public int getRadioEasy() {
		return radioEasy;
	}

	public int getRadioNormal() {
		return radioNormal;
	}

	public int getRadioDiff() {
		return radioDiff;
	}

	public int getCbEasy() {
		return cbEasy;
	}

	public int getCbNormal() {
		return cbNormal;
	}

	public int getCbDiff() {
		return cbDiff;
	}

	public void setRadioEasy(int radioEasy) {
		this.radioEasy = radioEasy;
	}

	public void setRadioNormal(int radioNormal) {
		this.radioNormal = radioNormal;
	}

	public void setRadioDiff(int radioDiff) {
		this.radioDiff = radioDiff;
	}

	public void setCbEasy(int cbEasy) {
		this.cbEasy = cbEasy;
	}

	public void setCbNormal(int cbNormal) {
		this.cbNormal = cbNormal;
	}

	public void setCbDiff(int cbDiff) {
		this.cbDiff = cbDiff;
	}

	public List<WrittenQuestion> getListRE() {
		return listRE;
	}

	public List<WrittenQuestion> getListRN() {
		return listRN;
	}

	public List<WrittenQuestion> getListRD() {
		return listRD;
	}

	public List<WrittenQuestion> getListCE() {
		return listCE;
	}

	public List<WrittenQuestion> getListCN() {
		return listCN;
	}

	public List<WrittenQuestion> getListCD() {
		return listCD;
	}

	public void setListRE(List<WrittenQuestion> listRE) {
		this.listRE = listRE;
	}

	public void setListRN(List<WrittenQuestion> listRN) {
		this.listRN = listRN;
	}

	public void setListRD(List<WrittenQuestion> listRD) {
		this.listRD = listRD;
	}

	public void setListCE(List<WrittenQuestion> listCE) {
		this.listCE = listCE;
	}

	public void setListCN(List<WrittenQuestion> listCN) {
		this.listCN = listCN;
	}

	public void setListCD(List<WrittenQuestion> listCD) {
		this.listCD = listCD;
	}

	public List<PaperClass> getPaperClasses() {
		return paperClasses;
	}

	public void setPaperClasses(List<PaperClass> paperClasses) {
		this.paperClasses = paperClasses;
	}

	/**
	 * @return the qids
	 */
	public String getQids() {
		return qids;
	}

	/**
	 * @param qids the qids to set
	 */
	public void setQids(String qids) {
		this.qids = qids;
	}

}
