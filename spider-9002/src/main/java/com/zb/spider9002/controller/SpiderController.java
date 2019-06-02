package com.zb.spider9002.controller;

import com.zb.spider9002.myspider.JobCrawler;
import com.zb.spider9002.myspider.JobUrlCrawler;
import com.zb.spider9002.myspider.UrlCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpiderController {


    @Autowired
    JobCrawler jobCrawler;

    @RequestMapping(value = "jobcrawler")
    public void startJobCrawler() {
        jobCrawler.crawl();
    }

    @Autowired
    UrlCrawler urlCrawler;

    @RequestMapping(value = "urlcrawler")
    public void startUrlCrawler() {
        urlCrawler.crawl();
    }

    @Autowired
    JobUrlCrawler jobUrlCrawler;
    @RequestMapping(value = "test")
    public void start(){
        jobUrlCrawler.crawl();
    }
}
