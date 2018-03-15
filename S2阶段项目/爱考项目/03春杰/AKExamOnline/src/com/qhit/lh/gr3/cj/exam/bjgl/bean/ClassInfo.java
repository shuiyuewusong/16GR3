package com.qhit.lh.gr3.cj.exam.bjgl.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.qhit.lh.gr3.cj.exam.sjgl.bean.PaperClass;
import com.qhit.lh.gr3.cj.exam.xsgl.bean.Student;

/**
 * ClassInfo entity. @author MyEclipse Persistence Tools
 */

/**类名:ClassInfo
  *创建时间:2018年3月13日
  *创建人:Disdain
  */
public class ClassInfo implements java.io.Serializable {

	// Fields

	private String ccode;
	private String cname;
	private String major;
	private String insId;
	private String iecId;
	private Date cdate;
	private Integer g1num;
	private Integer g2num;
	private Integer g3num;
	private Integer csId;
	private String cremark;

	//1-n
	private Set<Student> students = new HashSet<>();
	//1-n
	private Set<PaperClass> paperClasses = new HashSet<>(); 

	// Constructors

	/** default constructor */
	public ClassInfo() {
	}

	/** minimal constructor */
	public ClassInfo(String ccode, String cname, String major, String insId,
			String iecId, Date cdate) {
		this.ccode = ccode;
		this.cname = cname;
		this.major = major;
		this.insId = insId;
		this.iecId = iecId;
		this.cdate = cdate;
	}

	/** full constructor */
	public ClassInfo(String ccode, String cname, String major, String insId,
			String iecId, Date cdate, Integer g1num, Integer g2num,
			Integer g3num, Integer csId, String cremark) {
		this.ccode = ccode;
		this.cname = cname;
		this.major = major;
		this.insId = insId;
		this.iecId = iecId;
		this.cdate = cdate;
		this.g1num = g1num;
		this.g2num = g2num;
		this.g3num = g3num;
		this.csId = csId;
		this.cremark = cremark;
	}

	// Property accessors

	public String getCcode() {
		return this.ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getInsId() {
		return this.insId;
	}

	public void setInsId(String insId) {
		this.insId = insId;
	}

	public String getIecId() {
		return this.iecId;
	}

	public void setIecId(String iecId) {
		this.iecId = iecId;
	}

	public Date getCdate() {
		return this.cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Integer getG1num() {
		return this.g1num;
	}

	public void setG1num(Integer g1num) {
		this.g1num = g1num;
	}

	public Integer getG2num() {
		return this.g2num;
	}

	public void setG2num(Integer g2num) {
		this.g2num = g2num;
	}

	public Integer getG3num() {
		return this.g3num;
	}

	public void setG3num(Integer g3num) {
		this.g3num = g3num;
	}

	public Integer getCsId() {
		return this.csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCremark() {
		return this.cremark;
	}

	public void setCremark(String cremark) {
		this.cremark = cremark;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public Set<PaperClass> getPaperClasses() {
		return paperClasses;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void setPaperClasses(Set<PaperClass> paperClasses) {
		this.paperClasses = paperClasses;
	}

}