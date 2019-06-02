package com.zb.base.baseentity;

import java.util.Date;

public class UIntrouduceEntity {
    private Integer mFrom;

    private Integer mAccept;

    private Date mDate;

    private String mMessage;

    public Integer getmFrom() {
        return mFrom;
    }

    public void setmFrom(Integer mFrom) {
        this.mFrom = mFrom;
    }

    public Integer getmAccept() {
        return mAccept;
    }

    public void setmAccept(Integer mAccept) {
        this.mAccept = mAccept;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage == null ? null : mMessage.trim();
    }
}