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
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_survey", referencedColumnName = "id")
    Survey survey;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "id_student", referencedColumnName = "id")
    Student student;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_qc", referencedColumnName = "id")
    QOCourse qCourse;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_qt", referencedColumnName = "id")
    QOTeacher qTeacher;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_qi", referencedColumnName = "id")
    QInfos qInfos;

    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_qr", referencedColumnName = "id")
    QRemarks qRemarks;

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public QOCourse getqCourse() {
        return qCourse;
    }

    public void setqCourse(QOCourse qCourse) {
        this.qCourse = qCourse;
    }

    public QOTeacher getqTeacher() {
        return qTeacher;
    }

    public void setqTeacher(QOTeacher qTeacher) {
        this.qTeacher = qTeacher;
    }

    public QInfos getqInfos() {
        return qInfos;
    }

    public void setqInfos(QInfos qInfos) {
        this.qInfos = qInfos;
    }

    public QRemarks getqRemarks() {
        return qRemarks;
    }

    public void setqRemarks(QRemarks qRemarks) {
        this.qRemarks = qRemarks;
    }

    
}