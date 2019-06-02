package com.zb.base.mapper;


import com.zb.base.entity.PLanguageEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PLanguageEntityMapper {
    int deleteByPrimaryKey(Integer lId);

    int insert(PLanguageEntity record);

    int insertSelective(PLanguageEntity record);

    PLanguageEntity selectByPrimaryKey(Integer lId);

    int updateByPrimaryKeySelective(PLanguageEntity record);

    int updateByPrimaryKey(PLanguageEntity record);
}