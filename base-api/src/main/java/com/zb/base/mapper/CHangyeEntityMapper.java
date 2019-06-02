package com.zb.base.mapper;


import com.zb.base.entity.CHangyeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CHangyeEntityMapper {
    int deleteByPrimaryKey(Integer hId);

    int insert(CHangyeEntity record);

    int insertSelective(CHangyeEntity record);

    CHangyeEntity selectByPrimaryKey(Integer hId);

    int updateByPrimaryKeySelective(CHangyeEntity record);

    int updateByPrimaryKey(CHangyeEntity record);

//    新增
    Integer selectByName(String hangye);
}