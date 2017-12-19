package com.qhit.lh.gr3.cj.t4.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Work entity. @author MyEclipse Persistence Tools
 */

public class Work implements java.io.Serializable {

	// Fields

	private Integer id;
	private String workname;
	
	
	private Set<User> users = new HashSet<User>();
	
	// Constructors

	/** default constructor */
	public Work() {
	}
	
	public Work(Integer id, String workname) {
		super();
		this.id = id;
		this.workname = workname;
	}

	public Work(String workname, Set<User> users) {
		super();
		this.workname = workname;
		this.users = users;
	}

	public Work(Integer id, String workname, Set<User> users) {
		super();
		this.id = id;
		this.workname = workname;
		this.users = users;
	}

	/** full constructor */
	public Work(String workname) {
		this.workname = workname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkname() {
		return this.workname;
	}

	public void setWorkname(String workname) {
		this.workname = workname;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	



}