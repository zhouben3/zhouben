package com.zb.base.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Document(indexName = "crongzi",type = "cRongziEntity")
public class CRongziEntity implements Serializable {
    @Id
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