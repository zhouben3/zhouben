package com.zb.user9999.mapper;


import com.zb.base.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    UserEntity selectByMail(String mail);

}