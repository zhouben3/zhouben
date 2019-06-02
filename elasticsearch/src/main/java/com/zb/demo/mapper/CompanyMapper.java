package com.zb.demo.mapper;

import com.zb.base.entity.CompanyEntity;
import com.zb.base.mapper.CompanyEntityMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper extends CompanyEntityMapper {
    List<CompanyEntity> listSelect(@Param("start") Integer start, @Param("end") Integer end);
}
