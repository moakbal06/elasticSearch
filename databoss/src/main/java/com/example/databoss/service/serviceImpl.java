package com.example.databoss.service;


import com.example.databoss.model.Flight;
import com.example.databoss.repository.FlightRepository;
import org.apache.catalina.User;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Repository
public class serviceImpl {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    RestHighLevelClient client;


    public List<String> getTop5() throws IOException {

        TermsAggregationBuilder aggregation = AggregationBuilders.terms("top_5_carriers")
                .field("Carrier").size(5)
                .order(BucketOrder.count(false));
        SearchSourceBuilder builder = new SearchSourceBuilder().aggregation(aggregation);

        SearchRequest searchRequest =
                new SearchRequest().indices("kibana_sample_data_flights").source(builder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        Map<String, Aggregation> results = response.getAggregations().asMap();
        ParsedStringTerms topTags = (ParsedStringTerms) results.get("top_5_carriers");

        List<String> keys = topTags.getBuckets()
                .stream()
                .map(b -> b.getKeyAsString())
                .collect(toList());
        return keys;

    }
}
