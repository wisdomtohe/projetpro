package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends BaseEntity{
	String matricule;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_classe", referencedColumnName = "id")
	private Classe classe;

	@OneToOne(mappedBy = "student")
    private Response response;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
}
