package com.zb.demo.serviceimpl;

import com.zb.demo.bean.CompanyBean;
import com.zb.demo.elasticsearch.PositionRepository;
import com.zb.demo.service.SearchService;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    PositionRepository positionRepository;
    @Override
    public List<CompanyBean> search(String content, Double pMinware, Double pMaxmare, Integer pEdu, Integer pExp, Integer pFrom, boolean pIsstu, Integer cGuimo, Integer cHangye) {
        //QueryBuilder queryBuilder= QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("pFrom",pFrom));
        BoolQueryBuilder queryBuilder= QueryBuilders.boolQuery();
        if(pMaxmare!=null){
            queryBuilder.must(QueryBuilders.rangeQuery("pMaxware").gt(pMinware).lt(pMaxmare));
        }
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();
        return null;
    }
}
