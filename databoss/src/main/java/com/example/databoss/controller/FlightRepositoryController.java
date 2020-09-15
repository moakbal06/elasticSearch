package com.example.databoss.controller;


import com.example.databoss.model.Flight;
import com.example.databoss.repository.FlightRepository;
import com.example.databoss.service.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class FlightRepositoryController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private serviceImpl service;


    @GetMapping("/flight/venediceAnd500")
    public ResponseEntity<List<SearchHit<Flight>>> venediceAnd500() {

        List<SearchHit<Flight>> venediceAnd500 = flightRepository.findVenediceAnd500();

        return ResponseEntity.ok(venediceAnd500);
    }

    @GetMapping("/flight/top5")
    public ResponseEntity<List<String>> top5() throws IOException {

        List<String> top5 = service.getTop5();

        return ResponseEntity.ok(top5);
    }


}
