package com.qhit.lh.gr3.cj.t4.bean;

import java.util.List;

/**
 * @author 03春杰
 * TODO
 * 2017年12月18日上午10:41:45	
 */
public class Users {
	private String uname;
	private String upwd;
	private List<String> like;
	private String education;
	private int sex;
	

	public Users(String uname, String upwd, List<String> like, String education, int sex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.like = like;
		this.education = education;
		this.sex = sex;
	}
	public Users() {
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

	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public List<String> getLike() {
		return like;
	}
	public void setLike(List<String> like) {
		this.like = like;
	}
	
	
}
