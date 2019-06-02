package com.zb.base.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
@Document(indexName = "position",type = "Position")
public class PositionEntity implements Serializable {
    @Id
    private Integer pId;

    //@Field(type = FieldType.Text,index = false)
    private String pUrl;
    @Field(type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String pName;

    private Double pMaxware;

    private Double pMinware;

    private Boolean pIsmonth;

    private Date pCdate;

    private Integer pEdu;

    private Integer pNeednum;

    private Integer pExp;

    private Integer pCid;

    private Integer pFrom;

    private Boolean pIsstu;

    @Field(type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String pInfo;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl == null ? null : pUrl.trim();
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Double getpMaxware() {
        return pMaxware;
    }

    public void setpMaxware(Double pMaxware) {
        this.pMaxware = pMaxware;
    }

    public Double getpMinware() {
        return pMinware;
    }

    public void setpMinware(Double pMinware) {
        this.pMinware = pMinware;
    }

    public Boolean getpIsmonth() {
        return pIsmonth;
    }

    public void setpIsmonth(Boolean pIsmonth) {
        this.pIsmonth = pIsmonth;
    }

    public Date getpCdate() {
        return pCdate;
    }

    public void setpCdate(Date pCdate) {
        this.pCdate = pCdate;
    }

    public Integer getpEdu() {
        return pEdu;
    }

    public void setpEdu(Integer pEdu) {
        this.pEdu = pEdu;
    }

    public Integer getpNeednum() {
        return pNeednum;
    }

    public void setpNeednum(Integer pNeednum) {
        this.pNeednum = pNeednum;
    }

    public Integer getpExp() {
        return pExp;
    }

    public void setpExp(Integer pExp) {
        this.pExp = pExp;
    }

    public Integer getpCid() {
        return pCid;
    }

    public void setpCid(Integer pCid) {
        this.pCid = pCid;
    }

    public Integer getpFrom() {
        return pFrom;
    }

    public void setpFrom(Integer pFrom) {
        this.pFrom = pFrom;
    }

    public Boolean getpIsstu() {
        return pIsstu;
    }

    public void setpIsstu(Boolean pIsstu) {
        this.pIsstu = pIsstu;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo == null ? null : pInfo.trim();
    }

    @Override
    public String toString() {
        return "PositionEntity{" +
                "pId=" + pId +
                ", pUrl='" + pUrl + '\'' +
                ", pName='" + pName + '\'' +
                ", pMaxware=" + pMaxware +
                ", pMinware=" + pMinware +
                ", pIsmonth=" + pIsmonth +
                ", pCdate=" + pCdate +
                ", pEdu=" + pEdu +
                ", pNeednum=" + pNeednum +
                ", pExp=" + pExp +
                ", pCid=" + pCid +
                ", pFrom=" + pFrom +
                ", pIsstu=" + pIsstu +
                ", pInfo='" + pInfo + '\'' +
                '}';
    }
}