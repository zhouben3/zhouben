package com.zb.base.mapper;


import com.zb.base.entity.PositionEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PositionEntityMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(PositionEntity record);

    int insertSelective(PositionEntity record);

    PositionEntity selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(PositionEntity record);

    int updateByPrimaryKey(PositionEntity record);

    //新增
    Integer selectByUrl(String url);

}