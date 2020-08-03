package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;

@Entity
public class Question  extends BaseEntity{	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * @OneToMany(mappedBy = "question", cascade = { CascadeType.ALL })
	 * // @OneToMany(cascade = { CascadeType.ALL }) private List<CatSurveyQuestion>
	 * cat_survey_questions = new ArrayList<>();
	 * 
	 * @OneToMany(mappedBy = "question", cascade = {CascadeType.ALL}) private
	 * List<StudentSurvey> studentSurveys = new ArrayList<>();
	 */
        
        
}
