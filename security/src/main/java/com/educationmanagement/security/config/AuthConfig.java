package com.educationmanagement.security.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("auth-config")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthConfig {
    private List<String> byPassUriList;
    private String jwkProvider;
    private String envValue;
    private List<String> basePathList;
    private boolean authEnabled;
    private String authorizationPath;
    private boolean authorizationEnabled;
    private String environment;
}
