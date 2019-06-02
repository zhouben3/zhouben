package com.zb.demo.mapper;

import com.zb.base.entity.PositionEntity;
import com.zb.base.mapper.PositionEntityMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper extends PositionEntityMapper {
    List<PositionEntity> listSelect(@Param("start") Integer start, @Param("end") Integer end);
}
