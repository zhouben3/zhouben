package com.zb.base.baseentity;

public class PExperienceEntity {
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