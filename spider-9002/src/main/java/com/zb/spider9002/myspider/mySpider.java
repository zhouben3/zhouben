package com.zb.spider9002.myspider;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class mySpider extends Spider {
    private ReentrantLock newUrlLock = new ReentrantLock();

    private Condition newUrlCondition = newUrlLock.newCondition();
    /**
     * create a spider with pageProcessor.
     *
     * @param pageProcessor pageProcessor
     */
    public mySpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }
    public Spider addUrl(String... urls) {
        for (String url : urls) {
            addRequest(new Request(url));
        }
        signalNewUrl();
        return this;
    }
    private void signalNewUrl() {
        try {
            newUrlLock.lock();
            newUrlCondition.signalAll();
        } finally {
            newUrlLock.unlock();
        }
    }
}
