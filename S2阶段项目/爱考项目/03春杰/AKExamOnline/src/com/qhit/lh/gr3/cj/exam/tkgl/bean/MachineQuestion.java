package com.qhit.lh.gr3.cj.exam.tkgl.bean;

import com.qhit.lh.gr3.cj.exam.kmgl.bean.Course;

/**
 * MachineTest entity. @author MyEclipse Persistence Tools
 */

public class MachineQuestion implements java.io.Serializable {

	// Fields

	private Integer qid;
	private String qtitle;
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
	public MachineQuestion() {
	}

	

	public MachineQuestion(Integer qid, String qtitle, String degree, Integer csId,
			String chapter) {
		super();
		this.qid = qid;
		this.qtitle = qtitle;
		this.degree = degree;
		this.csId = csId;
		this.chapter = chapter;
	}

	/** minimal constructor */

	// Property accessors
	
	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}
	public Integer getQid() {
		return this.qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getQtitle() {
		return this.qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getChapter() {
		return this.chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

}