package com.zb.base.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Document(indexName = "url",type = "Url")
public class UrlEntity implements Serializable {
    private String url;

    @Override
    public String toString() {
        return "UrlEntity{" +
                "url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}