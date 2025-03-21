package com.siemens.accountapi.configurations;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(VaultConfiguration.class)
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;


    private DataSourceBuilder dataSourceBuilder;
    private final VaultConfiguration vaultConfiguration;

   public DatabaseConfiguration (VaultConfiguration vaultConfig)
    {
        this.vaultConfiguration=vaultConfig;
    }


    @Bean

    public DataSource getDataSource()
    {
        System.out.println("Entering Given Env.....");
        // System.out.println("User Name..."+vaultConfiguration.getUsername1());
       // System.out.println("Password..."+vaultConfiguration.getPassword1());
        System.out.println("User Name..."+vaultConfiguration.getMysqlusername());
        System.out.println("Password..."+vaultConfiguration.getPassword());
        dataSourceBuilder=DataSourceBuilder.create();
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.username(vaultConfiguration.getMysqlusername());
        dataSourceBuilder.password(vaultConfiguration.getPassword());
        dataSourceBuilder.driverClassName(driver);
        return dataSourceBuilder.build();

    }

}
