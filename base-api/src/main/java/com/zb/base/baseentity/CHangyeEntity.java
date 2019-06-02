package com.zb.base.baseentity;

public class CHangyeEntity {
    private Integer hId;

    private String hName;

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName == null ? null : hName.trim();
    }
}