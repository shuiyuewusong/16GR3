package com.qhit.lh.gr3.cj.t3.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Work work;
	private String uname;
	private String sex;
	private Integer workid;
	private Account account;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Work work) {
		this.work = work;
	}
	
	public User(Integer id, String uname, String sex, Integer workid) {
		super();
		this.id = id;
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
	}

	public User(Integer id, Work work, String uname, String sex, Integer workid, Account account) {
		super();
		this.id = id;
		this.work = work;
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
		this.account = account;
	}

	/** full constructor */
	public User(Work work, String uname, String sex, Integer workid, Account account) {
		this.work = work;
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
		this.account = account;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Work getWork() {
		return this.work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getWorkid() {
		return this.workid;
	}

	public void setWorkid(Integer workid) {
		this.workid = workid;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", sex=" + sex + ", workid=" + workid
				+ ", account=" + account.toString() + ",work=" + work.toString() + " ]";
	}
	
}