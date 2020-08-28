package com.ipnetinstitute.csc394.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course extends BaseEntity {
	private String name;
	private String code;
	
	@ManyToMany(mappedBy = "courses")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<Classe> classes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_teacher")
	private Teacher teacher;

	@OneToMany(mappedBy = "course")
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}


}
