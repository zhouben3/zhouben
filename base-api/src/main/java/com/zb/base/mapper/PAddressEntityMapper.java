package com.zb.base.mapper;


import com.zb.base.entity.PAddressEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PAddressEntityMapper {
    int insert(PAddressEntity record);

    int insertSelective(PAddressEntity record);
}