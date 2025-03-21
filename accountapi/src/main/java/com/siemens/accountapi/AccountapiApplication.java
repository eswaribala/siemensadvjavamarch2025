package com.siemens.accountapi;

import com.siemens.accountapi.configurations.VaultConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties(VaultConfiguration.class)
@EnableDiscoveryClient
public class AccountapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountapiApplication.class, args);
    }

}
