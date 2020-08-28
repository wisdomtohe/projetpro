package com.ipnetinstitute.csc394.backend.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Survey extends BaseEntity {
	public Survey() {
	}

	public Survey(String libelle, String code, String description, Date validite, Course course, List<Question> questions, Response response) {
		this.libelle = libelle;
		this.code = code;
		this.description = description;
		this.validite = validite;
		this.course = course;
		this.questions = questions;
		this.response = response;
	}

	String libelle, code, description;

	Date validite;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_course")
	private Course course;

	@ManyToMany(targetEntity = Question.class)
	@JoinTable(
	  name = "survey_has_question",
	  joinColumns = @JoinColumn(name = "id_survey"),
	  inverseJoinColumns = @JoinColumn(name = "id_question"))
	private List<Question> questions;

	@OneToOne(mappedBy = "survey")
    private Response response;

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

	public Date getValidite() {
		return validite;
	}

	public void setValidite(Date validite) {
		this.validite = validite;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
