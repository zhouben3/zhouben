package com.zb.base.baseentity;

import java.util.Date;

public class PositionEntity {
    private Integer pId;

    private String pUrl;

    private Double pMaxware;

    private Double pMinware;

    private Date pCdate;

    private Integer pEdu;

    private Integer pNeednum;

    private Integer pExp;

    private Integer pCid;

    private Integer pFrom;

    private Boolean pIsstu;

    private String pInfo;

    private Integer pLang;

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

    public Integer getpLang() {
        return pLang;
    }

    public void setpLang(Integer pLang) {
        this.pLang = pLang;
    }
}