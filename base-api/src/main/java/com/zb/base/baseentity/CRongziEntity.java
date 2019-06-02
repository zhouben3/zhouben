package com.zb.base.baseentity;

public class CRongziEntity {
    private Integer cCid;

    private String cJieduan;

    public Integer getcCid() {
        return cCid;
    }

    public void setcCid(Integer cCid) {
        this.cCid = cCid;
    }

    public String getcJieduan() {
        return cJieduan;
    }

    public void setcJieduan(String cJieduan) {
        this.cJieduan = cJieduan == null ? null : cJieduan.trim();
    }
}