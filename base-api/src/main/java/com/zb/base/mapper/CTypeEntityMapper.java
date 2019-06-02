package com.zb.base.mapper;


import com.zb.base.entity.CTypeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CTypeEntityMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(CTypeEntity record);

    int insertSelective(CTypeEntity record);

    CTypeEntity selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(CTypeEntity record);

    int updateByPrimaryKey(CTypeEntity record);

    //新增
    Integer selectByName(String content);
}