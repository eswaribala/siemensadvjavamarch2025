package com.siemens.resillience4jdemo.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.time.LocalDateTime;

@Service
@Slf4j
public class CBService {
    @Value("${serviceUrl}")
    private String serviceUrl;
    @Value("${alternativeServiceUrl}")
    private String alternateServiceUrl;
    @Autowired
    private RestClient restClient;

    @CircuitBreaker(name = "gatewayCircuitBreaker", fallbackMethod = "CBFallbackAccountService")
    @Retry(name = "gatewayRetry")
    public String CBAccountService() {

        log.info("Entering Primary method @="+ LocalDateTime.now());
        return  restClient.get()
                .uri(serviceUrl)
                .retrieve()
                .body(String.class);


    }

    public String CBFallbackAccountService(Exception e) {
        log.info("Entering Fallback method @="+ LocalDateTime.now() + e.getMessage());
        return  restClient.get()
                .uri(alternateServiceUrl)
                .retrieve()
                .body(String.class);



    }

}
