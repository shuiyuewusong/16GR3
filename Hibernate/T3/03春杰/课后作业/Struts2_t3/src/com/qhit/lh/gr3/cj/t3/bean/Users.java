package com.qhit.lh.gr3.cj.t3.bean;

import java.util.Date;

/**
 * @author 03春杰 TODO 2017年12月18日上午10:51:35
 */
public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String uname;
	private String upwd;
	private String age;
	private Date birthday;
	private String addres;
	private String sex;
	private String telphone;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String uname, String upwd, String age, Date birthday, String addres, String sex, String telphone) {
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.birthday = birthday;
		this.addres = addres;
		this.sex = sex;
		this.telphone = telphone;
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

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddres() {
		return this.addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

}