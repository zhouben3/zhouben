package com.zb.base.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;
@Document(indexName = "umessage",type = "uMessage")
public class UMessageEntity implements Serializable {
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