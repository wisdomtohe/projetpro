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

	@OneToOne(fetch = FetchType.EAGER)
	    @JoinTable(name = "user_is_teacher",
	      joinColumns =
	        { @JoinColumn(name = "id_teacher") },
	      inverseJoinColumns =
	        { @JoinColumn(name = "id_user") })
	private User user;

	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable( name = "course_teacher", joinColumns = {
			@JoinColumn( name = "id_teacher") },
			inverseJoinColumns = {
				@JoinColumn( name = "id_course")
			} )
	private List<Course> courses;

	public Teacher(String matricule, User user, List<Course> courses, List<Classe> classes) {
		this.matricule = matricule;
		this.user = user;
		this.courses = courses;
	}

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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
