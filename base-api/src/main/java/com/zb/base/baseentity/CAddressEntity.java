package com.zb.base.baseentity;

public class CAddressEntity {
    private Integer aCid;

    private String aAddress;

    public Integer getaCid() {
        return aCid;
    }

    public void setaCid(Integer aCid) {
        this.aCid = aCid;
    }

    public String getaAddress() {
        return aAddress;
    }

    public void setaAddress(String aAddress) {
        this.aAddress = aAddress == null ? null : aAddress.trim();
    }
}