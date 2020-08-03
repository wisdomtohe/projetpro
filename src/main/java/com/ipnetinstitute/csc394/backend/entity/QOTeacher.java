package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "q_teacher")
public class QOTeacher extends BaseEntity {
    
    @OneToOne(mappedBy = "qTeacher")
    private Response response;
    Integer relationEE, habilete, capaciteEcoute, disponibilite, maitrise, presentationVesti, appreciationGenerale;
    Boolean boolComment;
    String comment;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Integer getRelationEE() {
        return relationEE;
    }

    public void setRelationEE(Integer relationEE) {
        this.relationEE = relationEE;
    }

    public Integer getHabilete() {
        return habilete;
    }

    public void setHabilete(Integer habilete) {
        this.habilete = habilete;
    }

    public Integer getCapaciteEcoute() {
        return capaciteEcoute;
    }

    public void setCapaciteEcoute(Integer capaciteEcoute) {
        this.capaciteEcoute = capaciteEcoute;
    }

    public Integer getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Integer disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Integer getMaitrise() {
        return maitrise;
    }

    public void setMaitrise(Integer maitrise) {
        this.maitrise = maitrise;
    }

    public Integer getPresentationVesti() {
        return presentationVesti;
    }

    public void setPresentationVesti(Integer presentationVesti) {
        this.presentationVesti = presentationVesti;
    }

    public Integer getAppreciationGenerale() {
        return appreciationGenerale;
    }

    public void setAppreciationGenerale(Integer appreciationGenerale) {
        this.appreciationGenerale = appreciationGenerale;
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
    
}