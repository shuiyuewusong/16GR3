package com.qhit.lh.gr3.cj.t4.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String uname;
	private String sex;
	private Integer workid;
	
	
	private Account account;
	private Work work;
	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	
	public User(String uname, String sex, Integer workid, Account account) {
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
		this.account = account;
	}

	public User(Integer id, String uname, String sex, Integer workid, Work work) {
		super();
		this.id = id;
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
		this.work = work;
	}

	public User(Integer id, String uname, String sex, Integer workid, Account account) {
		super();
		this.id = id;
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
		this.account = account;
	}

	public User(Integer id, String uname, String sex, Integer workid) {
		super();
		this.id = id;
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
	}

	public User(Integer id, String uname, String sex, Integer workid, Account account, Work work) {
		super();
		this.id = id;
		this.uname = uname;
		this.sex = sex;
		this.workid = workid;
		this.account = account;
		this.work = work;
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

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", sex=" + sex + "]"
				+"work [workid="+workid +",work="+work.getWorkname()
				+"]"
				;
	}
	
	
}