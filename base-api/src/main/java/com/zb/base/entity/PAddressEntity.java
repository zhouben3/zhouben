package com.zb.base.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Document(indexName = "paddress",type = "pAddressEntity")
public class PAddressEntity implements Serializable {
    @Id
    private Integer apPid;

    private Integer apCity1;

    private Integer apCity2;

    public Integer getApPid() {
        return apPid;
    }

    public void setApPid(Integer apPid) {
        this.apPid = apPid;
    }

    public Integer getApCity1() {
        return apCity1;
    }

    public void setApCity1(Integer apCity1) {
        this.apCity1 = apCity1;
    }

    public Integer getApCity2() {
        return apCity2;
    }

    public void setApCity2(Integer apCity2) {
        this.apCity2 = apCity2;
    }
}