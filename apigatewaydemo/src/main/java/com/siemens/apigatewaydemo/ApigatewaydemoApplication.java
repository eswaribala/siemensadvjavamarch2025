package com.siemens.apigatewaydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewaydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigatewaydemoApplication.class, args);
    }

}
