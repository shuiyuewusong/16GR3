package com.qhit.lh.gr3.cj.exam.tkgl.bean;

import com.qhit.lh.gr3.cj.exam.kmgl.bean.Course;

/**
 * WrittenTest entity. @author MyEclipse Persistence Tools
 */

public class WrittenQuestion implements java.io.Serializable {

	// Fields

	private Integer qid;
	private String qtype;
	private String qtitle;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private String degree;
	private Integer csId;
	private String chapter;
	
	//n-1
	private Course course;

	// Constructors

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/** default constructor */
	public WrittenQuestion() {
	}

	/** minimal constructor */
	public WrittenQuestion(String qtype, String qtitle, String optionA,
			String optionB, String optionC, String optionD, String degree,
			Integer csId) {
		this.qtype = qtype;
		this.qtitle = qtitle;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.degree = degree;
		this.csId = csId;
	}

	/** full constructor */
	public WrittenQuestion(String qtype, String qtitle, String optionA,
			String optionB, String optionC, String optionD, String answer,
			String degree, Integer csId, String chapter) {
		this.qtype = qtype;
		this.qtitle = qtitle;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.degree = degree;
		this.csId = csId;
		this.chapter = chapter;
	}

	// Property accessors

	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getQtype() {
		return this.qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getQtitle() {
		return this.qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getOptionA() {
		return this.optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return this.optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return this.optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return this.optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getChapter() {
		return this.chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

}