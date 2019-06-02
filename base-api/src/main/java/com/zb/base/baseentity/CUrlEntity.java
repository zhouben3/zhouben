package com.zb.base.baseentity;

public class CUrlEntity {
    private Integer urlId;

    private String urlUrl;

    private Integer urlFrom;

    public Integer getUrlId() {
        return urlId;
    }

    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    public String getUrlUrl() {
        return urlUrl;
    }

    public void setUrlUrl(String urlUrl) {
        this.urlUrl = urlUrl == null ? null : urlUrl.trim();
    }

    public Integer getUrlFrom() {
        return urlFrom;
    }

    public void setUrlFrom(Integer urlFrom) {
        this.urlFrom = urlFrom;
    }
}