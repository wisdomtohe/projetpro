package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "q_course")
public class QOCourse extends BaseEntity {
    Integer clarte, compatibilite, coherence, support, ambiance, rythme, appGenerale;
    Boolean boolComment;
    String comment;

    @OneToOne(mappedBy = "qCourse")
    private Response response;

    public Integer getClarte() {
        return clarte;
    }

    public void setClarte(Integer clarte) {
        this.clarte = clarte;
    }

    public Integer getCompatibilite() {
        return compatibilite;
    }

    public void setCompatibilite(Integer compatibilite) {
        this.compatibilite = compatibilite;
    }

    public Integer getCoherence() {
        return coherence;
    }

    public void setCoherence(Integer coherence) {
        this.coherence = coherence;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(Integer ambiance) {
        this.ambiance = ambiance;
    }

    public Integer getRythme() {
        return rythme;
    }

    public void setRythme(Integer rythme) {
        this.rythme = rythme;
    }

    public Integer getAppGenerale() {
        return appGenerale;
    }

    public void setAppGenerale(Integer appGenerale) {
        this.appGenerale = appGenerale;
    }

    public Boolean getBoolComment() {
        return boolComment;
    }

    public void setBoolComment(Boolean boolComment) {
        this.boolComment = boolComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    
}