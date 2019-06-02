package com.zb.base.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;
@Document(indexName = "uintrouducce",type = "uIntrouduce")
public class UIntrouduceEntity implements Serializable {
    private Integer iUid;

    private String iUname;

    private Boolean iUsex;

    private Integer iUcity;

    private Date iUbirth;

    private String iUcareer;

    private String iUimage;

    private String iUfile;

    public Integer getiUid() {
        return iUid;
    }

    public void setiUid(Integer iUid) {
        this.iUid = iUid;
    }

    public String getiUname() {
        return iUname;
    }

    public void setiUname(String iUname) {
        this.iUname = iUname == null ? null : iUname.trim();
    }

    public Boolean getiUsex() {
        return iUsex;
    }

    public void setiUsex(Boolean iUsex) {
        this.iUsex = iUsex;
    }

    public Integer getiUcity() {
        return iUcity;
    }

    public void setiUcity(Integer iUcity) {
        this.iUcity = iUcity;
    }

    public Date getiUbirth() {
        return iUbirth;
    }

    public void setiUbirth(Date iUbirth) {
        this.iUbirth = iUbirth;
    }

    public String getiUcareer() {
        return iUcareer;
    }

    public void setiUcareer(String iUcareer) {
        this.iUcareer = iUcareer == null ? null : iUcareer.trim();
    }

    public String getiUimage() {
        return iUimage;
    }

    public void setiUimage(String iUimage) {
        this.iUimage = iUimage == null ? null : iUimage.trim();
    }

    public String getiUfile() {
        return iUfile;
    }

    public void setiUfile(String iUfile) {
        this.iUfile = iUfile == null ? null : iUfile.trim();
    }
}