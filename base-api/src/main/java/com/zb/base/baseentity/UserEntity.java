package com.zb.base.baseentity;

import java.util.Date;

public class UserEntity {
    private Integer uId;

    private String uEmail;

    private String uPass;

    private Date uCtime;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass == null ? null : uPass.trim();
    }

    public Date getuCtime() {
        return uCtime;
    }

    public void setuCtime(Date uCtime) {
        this.uCtime = uCtime;
    }
}