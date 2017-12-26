package com.qhit.lh.gr3.cj.t7.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String fileLocation;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String fileLocation) {
		this.name = name;
		this.fileLocation = fileLocation;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}