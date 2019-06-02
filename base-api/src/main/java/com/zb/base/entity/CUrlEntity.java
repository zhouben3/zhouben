package com.zb.base.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Document(indexName = "curl",type="cUrl")
public class CUrlEntity implements Serializable {
    @Id
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