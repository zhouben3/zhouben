package com.zb.spider9002;


import com.zb.base.entity.PositionEntity;
import com.zb.base.mapper.CompanyEntityMapper;
import com.zb.base.mapper.PositionEntityMapper;
import com.zb.base.mapper.UrlEntityMapper;
import com.zb.spider9002.myspider.JobUrlCrawler;
import com.zb.spider9002.pipeline.JobUrlDaoPipeline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spider9002ApplicationTests {
@Autowired
    DataSource dataSource;
    @Autowired
    PositionEntityMapper positionEntityMapper;
    @Autowired
    CompanyEntityMapper companyEntityMapper;
    @Autowired
    UrlEntityMapper urlEntityMapper;
//    @Autowired
//    JobUrlDaoPipeline jobUrlDaoPipeline;
//    @Autowired
//    JobUrlCrawler jobUrlCrawler;
//    @Autowired
//    MyPipeline myPipeline;
    @Test
    public void contextLoads() throws SQLException {
        //System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        //System.out.println(connection);
        PositionEntity positionEntity=new PositionEntity();
        //positionEntity.setpFrom(1);
       //positionEntity.setpUrl("1");
        //companyEntityMapper.selectbyName("test");
        //System.out.println(companyEntityMapper.selectByPrimaryKey("1111"));
       // positionEntityMapper.insert(positionEntity);
       // MyPipeline myPipeline=new MyPipeline();
        //System.out.println(myPipeline);

    }
    @Test
    public void selectMapperTest(){
       // List<UrlEntity> list=urlEntityMapper.selectNum(0,10000);
       // System.out.println(list.size());
    }

    @Test
    public void selectTest(){
       //String url=jobUrlDaoPipeline.selcet();
      // System.out.println(url);
        //jobUrlCrawler.crawl();
    }
}
