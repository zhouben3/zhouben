package com.zb.spider9002.myspider;

import com.zb.spider9002.model.JobBean;
import com.zb.spider9002.model.JobUrlBean;
import com.zb.spider9002.pipeline.JobUrlDaoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.model.OOSpider;
import com.zb.spider9002.webmagic.OOSpider;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobUrlCrawler {

    @Qualifier("JobUrlDaoPipeline")
    @Autowired
    //private PageModelPipeline jobUrlDaoPipeline;
    private JobUrlDaoPipeline jobUrlDaoPipeline;

    public void crawl() {
        for (int i = 0; i < 93; i++) {
            int start = i * 10000;
            int end = start + 10000;
            List<String> urllist = jobUrlDaoPipeline.selcet(start, end);
            OOSpider.create(Site.me()
                    .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"), jobUrlDaoPipeline, JobUrlBean.class)
                    .addUrl(urllist)
                    .setSpawnUrl(false)
                    .thread(15)
                    //.thread(5)
                    .run();
        }
    }

//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
//        final JobCrawler jobCrawler = applicationContext.getBean(JobCrawler.class);
//        jobCrawler.crawl();
//    }

}
