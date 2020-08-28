package com.ipnetinstitute.csc394.backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo; 

@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, 
include = com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),     
    @JsonSubTypes.Type(value = Student.class, name = "student"),
    @JsonSubTypes.Type(value = Classe.class, name = "classe"),
    @JsonSubTypes.Type(value = Course.class, name = "course"),
	@JsonSubTypes.Type(value = Question.class, name = "question"),
    @JsonSubTypes.Type(value = Survey.class, name = "survey"),
	@JsonSubTypes.Type(value = Filiere.class, name = "filiere"),
    @JsonSubTypes.Type(value = User.class, name = "user"),
    @JsonSubTypes.Type(value = Response.class, name = "response")
    
}) 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract  class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = true)
	Date createdAt;
	@Column(nullable = true)
	Date updatedAt;
	@Column(nullable = true)
	Long modBy;
	
	@Transient
	String error;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateDateTime() {
		return createdAt;
	}
	public void setCreateDateTime(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModDateTime() {
		return updatedAt;
	}
	public void setModDateTime(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Long getModBy() {
		return modBy;
	}
	public void setModBy(Long modBy) {
		this.modBy = modBy;
	}
	
	
}
