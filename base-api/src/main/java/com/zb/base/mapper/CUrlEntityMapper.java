package com.zb.base.mapper;


import com.zb.base.entity.CUrlEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CUrlEntityMapper {
    int deleteByPrimaryKey(Integer urlId);

    int insert(CUrlEntity record);

    int insertSelective(CUrlEntity record);

    CUrlEntity selectByPrimaryKey(Integer urlId);

    int updateByPrimaryKeySelective(CUrlEntity record);

    int updateByPrimaryKey(CUrlEntity record);

    Integer selectByUrl(String url);
}