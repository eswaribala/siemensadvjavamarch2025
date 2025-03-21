package com.siemens.resillience4jdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class Resillience4jdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Resillience4jdemoApplication.class, args);
    }

    @Bean
    public RestClient getRestClient() {
        return RestClient.create();
    }
}
