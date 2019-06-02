package com.zb.base.mapper;


import com.zb.base.entity.CompanyEntity;

public interface CompanyEntityMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(CompanyEntity record);

    int insertSelective(CompanyEntity record);

    CompanyEntity selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(CompanyEntity record);

    int updateByPrimaryKey(CompanyEntity record);

    Integer selectByName(String cName);
}