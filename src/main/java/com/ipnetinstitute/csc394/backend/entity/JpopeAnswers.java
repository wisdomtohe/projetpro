package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class JpopeAnswers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private int courseSurvey;
    private int mayaki;
    private int ahoeGnoe;
    private int piigo;
    private int doctorHelp;
    private int detectionIntrusion;
    private int ciscoIse;
    private int toIp;
    private int siem;
    private int nessus;
    Date reponduA;

    public JpopeAnswers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCourseSurvey() {
        return courseSurvey;
    }

    public void setCourseSurvey(int courseSurvey) {
        this.courseSurvey = courseSurvey;
    }

    public int getMayaki() {
        return mayaki;
    }

    public void setMayaki(int mayaki) {
        this.mayaki = mayaki;
    }

    public int getAhoeGnoe() {
        return ahoeGnoe;
    }

    public void setAhoeGnoe(int ahoeGnoe) {
        this.ahoeGnoe = ahoeGnoe;
    }

    public int getPiigo() {
        return piigo;
    }

    public void setPiigo(int piigo) {
        this.piigo = piigo;
    }

    public int getDoctorHelp() {
        return doctorHelp;
    }

    public void setDoctorHelp(int doctorHelp) {
        this.doctorHelp = doctorHelp;
    }

    public int getDetectionIntrusion() {
        return detectionIntrusion;
    }

    public void setDetectionIntrusion(int detectionIntrusion) {
        this.detectionIntrusion = detectionIntrusion;
    }

    public int getCiscoIse() {
        return ciscoIse;
    }

    public void setCiscoIse(int ciscoIse) {
        this.ciscoIse = ciscoIse;
    }

    public int getToIp() {
        return toIp;
    }

    public void setToIp(int toIp) {
        this.toIp = toIp;
    }

    public int getSiem() {
        return siem;
    }

    public void setSiem(int siem) {
        this.siem = siem;
    }

    public int getNessus() {
        return nessus;
    }

    public void setNessus(int nessus) {
        this.nessus = nessus;
    }

    public Date getReponduA() {
        return reponduA;
    }

    public void setReponduA(Date reponduA) {
        this.reponduA = reponduA;
    }
}
