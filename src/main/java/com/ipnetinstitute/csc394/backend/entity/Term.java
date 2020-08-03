package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;

@Entity
public class Term extends BaseEntity {
	String code;
	String name;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * @OneToMany(mappedBy = "term", cascade = {CascadeType.ALL} ) private List
	 * <Course> courses = new ArrayList<Course>();
	 */
}
