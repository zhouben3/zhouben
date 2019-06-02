package com.zb.spider9002.myspider;

import com.zb.spider9002.model.JobBean;
import com.zb.spider9002.model.Urlbean;
import com.zb.spider9002.pipeline.UrlPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * @author code4crafer@gmail.com
 *         Date: 13-6-23
 *         Time: 下午4:19
 */
@Component
public class UrlCrawler {

    @Qualifier("UrlPipeline")
    @Autowired
    private UrlPipeline urlPipeline;

    public void crawl() {
        OOSpider.create(Site.me()
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"),urlPipeline, Urlbean.class)
                .addUrl("https://jobs.51job.com/zhangjiagang/95928547.html?s=01&t=0")
                //.thread(5)
                .thread(30)
                .run();
    }

//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
//        final JobCrawler jobCrawler = applicationContext.getBean(JobCrawler.class);
//        jobCrawler.crawl();
//    }

}
