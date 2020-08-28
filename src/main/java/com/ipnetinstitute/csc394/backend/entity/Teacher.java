package com.ipnetinstitute.csc394.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Teacher extends BaseEntity{
	
	String matricule;

	public Teacher() {
	}

	public Teacher(String matricule, User user){
		this.matricule = matricule;
		this.user = user;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;

	@OneToMany(mappedBy = "teacher", cascade = {CascadeType.ALL})
	@JsonIgnore
	private List<Course> courses = new ArrayList<Course>();

	public Teacher(String matricule, User user, List<Course> courses, List<Classe> classes) {
		this.matricule = matricule;
		this.user = user;
		this.courses = courses;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"matricule='" + matricule + '\'' +
				", user=" + user +
				", courses=" + courses +
				'}';
	}
}
