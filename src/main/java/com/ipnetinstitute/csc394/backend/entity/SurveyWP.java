package com.ipnetinstitute.csc394.backend.entity;

import java.util.List;

public class SurveyWP {
    Survey survey;
    List<Course> courses;
    List<Question> questions;

    public SurveyWP() {
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public SurveyWP(Survey survey, List<Course> courses, List<Question> questions) {
        this.survey = survey;
        this.courses = courses;
        this.questions = questions;
    }
}
