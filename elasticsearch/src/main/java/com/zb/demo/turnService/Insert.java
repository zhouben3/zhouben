package com.zb.demo.turnService;

import com.zb.base.entity.CompanyEntity;
import com.zb.base.entity.PositionEntity;
import com.zb.base.mapper.CompanyEntityMapper;
import com.zb.base.mapper.PositionEntityMapper;
import com.zb.demo.elasticsearch.CompanyRespository;
import com.zb.demo.elasticsearch.PositionRepository;
import com.zb.demo.mapper.CompanyMapper;
import com.zb.demo.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Insert {
    @Autowired
    CompanyRespository companyRespository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    CompanyMapper companyMapper;
    //插入数据库的数据到elasticsearch
    public void insertCom(){
        for(int i=0;i<90;i++){
            int start=i*10000;
            int end=(i+1)*10000;
            List<CompanyEntity> listCom=companyMapper.listSelect(start,end);
            for(int j=0;j<listCom.size();j++){
                companyRespository.index(listCom.get(j));
            }
        }
    }
    public void insertPos(){
        for(int i=0;i<90;i++){
            int start=i*10000;
            int end=(i+1)*10000;
            List<PositionEntity> listPos=positionMapper.listSelect(start,end);
            for(int j=0;j<listPos.size();j++){
                positionRepository.index(listPos.get(j));
            }
        }
    }
}
