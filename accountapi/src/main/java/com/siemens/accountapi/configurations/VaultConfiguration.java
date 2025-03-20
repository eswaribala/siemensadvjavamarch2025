package com.siemens.accountapi.configurations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties
public class VaultConfiguration {
   // @Value("${vault.username}")
    private String mysqlusername;
    //@Value("${vault.password}")
    private String password;

}

