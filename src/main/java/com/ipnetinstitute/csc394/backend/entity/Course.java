package com.ipnetinstitute.csc394.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course extends BaseEntity {
	private String name;
	private String code;
	
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable( name = "classe_has_course", joinColumns = {
			@JoinColumn( name = "id_course") },
			inverseJoinColumns = {
				@JoinColumn( name = "id_classe")
			} )
	private List<Classe> classes;
	
	@ManyToMany( fetch = FetchType.LAZY, mappedBy = "courses" )
	@JsonIgnore
	private List<Teacher> teachers;

	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Survey> surveys;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
}
