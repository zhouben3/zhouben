package com.zb.demo.elasticsearch;

import com.zb.base.entity.PositionEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface PositionRepository extends ElasticsearchRepository<PositionEntity,Integer> {
 //Optional<PositionEntity> findById(Integer id);
}
