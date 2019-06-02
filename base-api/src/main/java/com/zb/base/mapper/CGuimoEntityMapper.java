package com.zb.base.mapper;


import com.zb.base.entity.CGuimoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CGuimoEntityMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(CGuimoEntity record);

    int insertSelective(CGuimoEntity record);

    CGuimoEntity selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(CGuimoEntity record);

    int updateByPrimaryKey(CGuimoEntity record);

    //新增
    Integer selectByName(String content);
}