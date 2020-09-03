package com.ipnetinstitute.csc394.backend.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Survey extends BaseEntity {
	public Survey() {
	}

	public Survey(String libelle, String code, String description, List<Course> courses, List<Question> questions) {
		this.libelle = libelle;
		this.code = code;
		this.description = description;
		this.courses = courses;
		this.questions = questions;
	}

	String libelle, code, description;

	Date beginDate;
	Date endDate;

	@ManyToMany
	@JoinTable(
	  name = "course_has_survey",
	  joinColumns = @JoinColumn(name = "id_survey"),
	  inverseJoinColumns = @JoinColumn(name = "id_course"))
	private List<Course> courses;

	@ManyToMany
	@JoinTable(
	  name = "survey_has_question",
	  joinColumns = @JoinColumn(name = "id_survey"),
	  inverseJoinColumns = @JoinColumn(name = "id_question"))
	private List<Question> questions;

	@OneToMany(mappedBy = "survey")
	@JsonIgnore
    private List<Response> responses;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
