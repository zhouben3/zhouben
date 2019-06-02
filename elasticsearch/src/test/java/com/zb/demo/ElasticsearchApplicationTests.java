package com.zb.demo;

import com.zb.base.entity.CompanyEntity;
import com.zb.base.entity.PositionEntity;
import com.zb.base.mapper.CompanyEntityMapper;
import com.zb.base.mapper.PositionEntityMapper;
import com.zb.demo.elasticsearch.CompanyRespository;
import com.zb.demo.elasticsearch.PositionRepository;
//import entity.PositionEntity;
import com.zb.demo.mapper.CompanyMapper;
import org.apache.lucene.util.QueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {


    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    PositionRepository positionRepository;

    @Test
    public void testindex() {
//        PositionEntity positionEntity=positionEntityMapper.selectByPrimaryKey(7177);
//        positionRepository.index(positionEntity);
        companyMapper.listSelect(0, 1000);
    }

    public PositionEntity testfind() {
        return null;
    }
}
