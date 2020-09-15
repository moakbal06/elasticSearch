package com.example.databoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
public class DatabossApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabossApplication.class, args);
    }

}
