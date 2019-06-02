package com.zb.base.mapper;

//import com.zb.spider9002.model.Urlbean;

import com.zb.base.entity.UrlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UrlEntityMapper {
    int deleteByPrimaryKey(String url);

    int insert(UrlEntity record);

    int insertSelective(UrlEntity record);

    UrlEntity selectByUrl(String url);

    List<String> selectNum(@Param("start") Integer start, @Param("end") Integer end);

}