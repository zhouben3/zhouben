package com.zb.spider9002.model;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;
@TargetUrl("https://jobs.51job.com/*.html\\?*")
public class Urlbean implements AfterExtractor{
        @ExtractByUrl(notNull = true)
        String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "UrlBean{" +
                    "url='" + url + '\'' +
                    '}';
        }

        @Override
        public void afterProcess(Page page) {
        System.out.println(url);
        }
    }

