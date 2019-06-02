package com.zb.base.mapper;


import com.zb.base.entity.CRongziEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CRongziEntityMapper {
    int deleteByPrimaryKey(Integer cCid);

    int insert(CRongziEntity record);

    int insertSelective(CRongziEntity record);

    CRongziEntity selectByPrimaryKey(Integer cCid);

    int updateByPrimaryKeySelective(CRongziEntity record);

    int updateByPrimaryKey(CRongziEntity record);
}