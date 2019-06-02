package com.zb.base.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Document(indexName = "pexperience",type = "pExperience")
public class PExperienceEntity implements Serializable {
    @Id
    private Integer exId;

    private String exName;

    public Integer getExId() {
        return exId;
    }

    public void setExId(Integer exId) {
        this.exId = exId;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName == null ? null : exName.trim();
    }
}