package com.ipnetinstitute.csc394.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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

	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
	@JsonIgnore
	private Response response;

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

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}


}
