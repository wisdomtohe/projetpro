package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.*;

@Entity
@Table(name= "response")
public class Response extends BaseEntity {
    public Response() {
    }

    public Response(int rating, Survey survey, Question question) {
        this.rating = rating;
        this.survey = survey;
        this.question = question;
    }

    String comments;
	Short isNa;
	Integer rating;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_survey", nullable = false)
	private Survey survey;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_student", nullable = false)
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_question", nullable = false)
	private Question question;
	
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Short getIsNa() {
        return isNa;
    }

    public void setIsNa(Short isNa) {
        this.isNa = isNa;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
