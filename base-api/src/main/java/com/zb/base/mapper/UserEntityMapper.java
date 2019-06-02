package com.zb.base.mapper;


import com.zb.base.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}