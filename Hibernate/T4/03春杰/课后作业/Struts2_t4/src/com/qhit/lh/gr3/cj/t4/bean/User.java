package com.qhit.lh.gr3.cj.t4.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String uname;
	private String upwd;
	private String like1;
	private String like2;
	private String like3;
	private String like4;
	private String education;
	private Integer sex;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String uname, String upwd, String education, Integer sex) {
		this.uname = uname;
		this.upwd = upwd;
		this.education = education;
		this.sex = sex;
	}

	/** full constructor */
	public User(String uname, String upwd, String like1, String like2, String like3, String like4, String education,
			Integer sex) {
		this.uname = uname;
		this.upwd = upwd;
		this.like1 = like1;
		this.like2 = like2;
		this.like3 = like3;
		this.like4 = like4;
		this.education = education;
		this.sex = sex;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getLike1() {
		return this.like1;
	}

	public void setLike1(String like1) {
		this.like1 = like1;
	}

	public String getLike2() {
		return this.like2;
	}

	public void setLike2(String like2) {
		this.like2 = like2;
	}

	public String getLike3() {
		return this.like3;
	}

	public void setLike3(String like3) {
		this.like3 = like3;
	}

	public String getLike4() {
		return this.like4;
	}

	public void setLike4(String like4) {
		this.like4 = like4;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}