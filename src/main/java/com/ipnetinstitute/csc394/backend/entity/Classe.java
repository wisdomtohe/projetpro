package com.ipnetinstitute.csc394.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classe extends BaseEntity{
	String code;
	String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_filiere")
	private Filiere filiere;

	@ManyToMany
	@JoinTable(
	  name = "class_has_course",
	  joinColumns = @JoinColumn(name = "id_classe"),
	  inverseJoinColumns = @JoinColumn(name = "id_course"))
	private List<Course> courses = new ArrayList<Course>() ;

	@OneToMany(mappedBy = "classe")
	@JsonIgnore
	private List<Student> students = new ArrayList<>() ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
