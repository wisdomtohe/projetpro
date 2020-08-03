package com.ipnetinstitute.csc394.backend.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "q_infos")
public class QInfos extends BaseEntity{
    private boolean boolComment;
    private String Comment;

    @OneToOne(mappedBy = "qInfos")
    private Response response;

    public boolean isBoolComment() {
        return boolComment;
    }

    public void setBoolComment(boolean boolComment) {
        this.boolComment = boolComment;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}