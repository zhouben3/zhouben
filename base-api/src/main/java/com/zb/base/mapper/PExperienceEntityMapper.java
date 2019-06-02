package com.zb.base.mapper;


import com.zb.base.entity.PExperienceEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PExperienceEntityMapper {
    int deleteByPrimaryKey(Integer exId);

    int insert(PExperienceEntity record);

    int insertSelective(PExperienceEntity record);

    PExperienceEntity selectByPrimaryKey(Integer exId);

    int updateByPrimaryKeySelective(PExperienceEntity record);

    int updateByPrimaryKey(PExperienceEntity record);

    //新增，根据经验查找
    Integer selectByExpName(String exp);
}