package com.zb.demo.elasticsearch;

import com.zb.base.entity.CompanyEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CompanyRespository extends ElasticsearchRepository<CompanyEntity, Integer> {

}
