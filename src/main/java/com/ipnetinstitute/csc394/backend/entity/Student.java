package com.ipnetinstitute.csc394.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student extends BaseEntity{
	String matricule;

	@OneToOne(fetch = FetchType.EAGER)
	    @JoinTable(name = "user_is_student",
	      joinColumns =
	        { @JoinColumn(name = "id_student") },
	      inverseJoinColumns =
	        { @JoinColumn(name = "id_user") })
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_classe")
	private Classe classe;

	@OneToOne(mappedBy = "student")
	@JsonIgnore
    private Response response;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
