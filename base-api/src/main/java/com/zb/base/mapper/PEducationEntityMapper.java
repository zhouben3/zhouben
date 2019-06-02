package com.zb.base.mapper;


import com.zb.base.entity.PEducationEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PEducationEntityMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(PEducationEntity record);

    int insertSelective(PEducationEntity record);

    PEducationEntity selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(PEducationEntity record);

    int updateByPrimaryKey(PEducationEntity record);
}