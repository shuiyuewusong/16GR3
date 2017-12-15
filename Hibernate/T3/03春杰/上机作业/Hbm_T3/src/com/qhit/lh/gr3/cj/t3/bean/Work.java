package com.qhit.lh.gr3.cj.t3.bean;

/**
 * Work entity. @author MyEclipse Persistence Tools
 */

public class Work implements java.io.Serializable {

	// Fields

	private Integer id;
	private String workname;


	// Constructors

	/** default constructor */
	public Work() {
	}

	/** full constructor */
	public Work(String workname) {
		this.workname = workname;

	}
	

	public Work(Integer id, String workname) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Work [id=" + id + ", workname=" + workname + "]";
	}


	
}	