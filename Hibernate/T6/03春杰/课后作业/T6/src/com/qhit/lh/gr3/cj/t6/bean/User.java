package com.qhit.lh.gr3.cj.t6.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String uname;
	private String upwd;
	private String birthday;
	private String sex;
	private Integer enable;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String uname, String upwd, String birthday, String sex, Integer enable) {
		this.uname = uname;
		this.upwd = upwd;
		this.birthday = birthday;
		this.sex = sex;
		this.enable = enable;
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

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getEnable() {
		return this.enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

}