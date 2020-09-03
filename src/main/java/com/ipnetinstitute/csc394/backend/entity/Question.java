package com.ipnetinstitute.csc394.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question  extends BaseEntity{	
	private String libelle;
	private String contenu;

	public Question() {
	}

	public Question(String libelle, String contenu) {
		this.libelle = libelle;
		this.contenu = contenu;
	}

	@ManyToMany(mappedBy = "questions")
	@JsonIgnore
	private List<Survey> surveys;

	@OneToMany(mappedBy = "question")
	@JsonIgnore
    private List<Response> responses;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}
}
