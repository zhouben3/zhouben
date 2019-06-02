package com.zb.base.mapper;


import com.zb.base.entity.DBFromEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DBFromEntityMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(DBFromEntity record);

    int insertSelective(DBFromEntity record);

    DBFromEntity selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(DBFromEntity record);

    int updateByPrimaryKey(DBFromEntity record);
}