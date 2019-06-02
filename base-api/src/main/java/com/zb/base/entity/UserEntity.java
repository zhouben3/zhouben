package com.zb.base.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;
@Document(indexName = "user",type = "User")
public class UserEntity implements Serializable {
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