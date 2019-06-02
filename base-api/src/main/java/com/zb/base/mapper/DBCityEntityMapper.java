package com.zb.base.mapper;


import com.zb.base.entity.DBCityEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DBCityEntityMapper {
    int deleteByPrimaryKey(Integer ctId);

    int insert(DBCityEntity record);

    int insertSelective(DBCityEntity record);

    DBCityEntity selectByPrimaryKey(Integer ctId);

    int updateByPrimaryKeySelective(DBCityEntity record);

    int updateByPrimaryKey(DBCityEntity record);

    //新增按照城市查
    Integer selectByName(String city);

    List<Integer> selectByNameList(String city);
}