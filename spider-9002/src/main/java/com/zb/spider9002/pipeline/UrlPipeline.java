package com.zb.spider9002.pipeline;

import com.zb.base.entity.UrlEntity;

import com.zb.base.mapper.UrlEntityMapper;
import com.zb.spider9002.model.JobBean;
import com.zb.spider9002.model.Urlbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

//抽取url,这边负责存入数据库
@Component("UrlPipeline")
public class UrlPipeline implements PageModelPipeline<Urlbean> {

    @Autowired
    UrlEntityMapper urlEntityMapper;
    @Override
    public void process(Urlbean urlbean, Task task) {
        UrlEntity urlEntity1=urlEntityMapper.selectByUrl(urlbean.getUrl());
        UrlEntity urlEntity2=new UrlEntity();
        urlEntity2.setUrl(urlbean.getUrl());
        if(urlEntity1==null){
            urlEntityMapper.insert(urlEntity2);
        }

    }
}
