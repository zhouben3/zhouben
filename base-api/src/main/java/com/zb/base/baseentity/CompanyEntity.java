package com.zb.base.baseentity;

public class CompanyEntity {
    private Integer cId;

    private String cName;

    private Integer cGuimo;

    private Integer cType;

    private Integer cHangye1;

    private Integer cHangye2;

    private String cInfo;

    private Integer cRongzi;

    private String cAddress;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getcGuimo() {
        return cGuimo;
    }

    public void setcGuimo(Integer cGuimo) {
        this.cGuimo = cGuimo;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public Integer getcHangye1() {
        return cHangye1;
    }

    public void setcHangye1(Integer cHangye1) {
        this.cHangye1 = cHangye1;
    }

    public Integer getcHangye2() {
        return cHangye2;
    }

    public void setcHangye2(Integer cHangye2) {
        this.cHangye2 = cHangye2;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo == null ? null : cInfo.trim();
    }

    public Integer getcRongzi() {
        return cRongzi;
    }

    public void setcRongzi(Integer cRongzi) {
        this.cRongzi = cRongzi;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }
}