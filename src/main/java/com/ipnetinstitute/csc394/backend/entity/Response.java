package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    int rating;

    @OneToOne
    @JoinColumn(name = "id_survey", referencedColumnName = "id")
    private Survey survey;

    @OneToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "id_question", referencedColumnName = "id")
    private Question question;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

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
}
