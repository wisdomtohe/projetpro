package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "cat_survey")

public class CatSurvey extends BaseEntity{
	
	String name;
	String description;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	/*
	 * @OneToMany(mappedBy = "cat_survey", cascade = {CascadeType.ALL}) private
	 * List<CatSurveyQuestion> catSurveyQuestions = new ArrayList<>();
	 */
//	 @OneToMany(mappedBy = "cat_survey", cascade = {CascadeType.ALL}) private
//	 List<Survey> surveys = new ArrayList<Survey>();
//	 

}
