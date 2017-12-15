package com.qhit.lh.gr3.cj.t3.bean;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String uname;
	private String password;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(User user) {
		this.user = user;
	}

	/** full constructor */
	public Account(User user, String uname, String password) {
		this.user = user;
		this.uname = uname;
		this.password = password;
	}
	
	// Property accessors

	public Account(Integer id, String uname, String password) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
	}

	public Account(Integer id, User user, String uname, String password) {
		super();
		this.id = id;
		this.user = user;
		this.uname = uname;
		this.password = password;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", uname=" + uname + ", password=" + password + "]";
	}
	

}