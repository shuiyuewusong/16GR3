package com.qhit.lh.gr3.cj.exam.sjgl.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.lh.gr3.cj.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.cj.exam.tkgl.bean.WrittenQuestion;

/**
 * Paper entity. @author MyEclipse Persistence Tools
 */

public class Paper implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String pname;
	private Integer ptime;
	private Integer ptotalScore;
	private Integer csId;
	private Integer qtotal;
	private Float qscore;
	private String ptype;
	private String pstate;
	
	//n-1
	private Course course;

	//1-n
	private Set<PaperClass> paperClasses = new HashSet<>(); 
	//m-n
	private Set<WrittenQuestion> writtenQuestions = new HashSet<>();

	// Constructors

	/** default constructor */
	public Paper() {
	}

	/** full constructor */
	public Paper(String pname, Integer ptime, Integer ptotalScore,
			Integer csId, Integer qtotal, Float qscore, String ptype,
			String pstate) {
		this.pname = pname;
		this.ptime = ptime;
		this.ptotalScore = ptotalScore;
		this.csId = csId;
		this.qtotal = qtotal;
		this.qscore = qscore;
		this.ptype = ptype;
		this.pstate = pstate;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getPtime() {
		return this.ptime;
	}

	public void setPtime(Integer ptime) {
		this.ptime = ptime;
	}

	public Integer getPtotalScore() {
		return this.ptotalScore;
	}

	public void setPtotalScore(Integer ptotalScore) {
		this.ptotalScore = ptotalScore;
	}

	public Integer getCsId() {
		return this.csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public Integer getQtotal() {
		return this.qtotal;
	}

	public void setQtotal(Integer qtotal) {
		this.qtotal = qtotal;
	}

	public Float getQscore() {
		return this.qscore;
	}

	public void setQscore(Float qscore) {
		this.qscore = qscore;
	}

	public String getPtype() {
		return this.ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPstate() {
		return this.pstate;
	}

	public void setPstate(String pstate) {
		this.pstate = pstate;
	}

	public Set<PaperClass> getPaperClasses() {
		return paperClasses;
	}

	public void setPaperClasses(Set<PaperClass> paperClasses) {
		this.paperClasses = paperClasses;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<WrittenQuestion> getWrittenQuestions() {
		return writtenQuestions;
	}

	public void setWrittenQuestions(Set<WrittenQuestion> writtenQuestions) {
		this.writtenQuestions = writtenQuestions;
	}

}