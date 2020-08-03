package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;

@Entity
public class Classe extends BaseEntity{
	
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/*
	 * @OneToMany(mappedBy = "classe", cascade = {CascadeType.ALL}) private
	 * List<Course> courses = new ArrayList<>() ;
	 */
}
