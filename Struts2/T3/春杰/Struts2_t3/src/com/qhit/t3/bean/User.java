package com.qhit.t3.bean;

import java.util.Date;

public class User {
	private String uname;
	private String upwd;
	private int age ;
	private Date birthday;
	private String sex;
	private String addres;
	private String telphone;
	public User(String uname, String upwd, int age, String sex, String addres, String telphone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.sex = sex;
		this.addres = addres;
		this.telphone = telphone;
	}
	public User(String uname, String upwd, int age, Date birthday, String sex, String addres, String telphone) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.addres = addres;
		this.telphone = telphone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	
	
}
