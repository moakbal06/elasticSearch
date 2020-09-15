package com.example.databoss.repository;

import com.example.databoss.model.Flight;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface FlightRepository extends ElasticsearchRepository<Flight, String> {


    @Query("{\"bool\":{\"filter\":{\"term\":{\"DestAirportID\":\"VE05\"}},\"must\":{\"range\":{\"AvgTicketPrice\":{\"gte\":0,\"lte\":500}}}}}")
    List<SearchHit<Flight>> findVenediceAnd500();

}