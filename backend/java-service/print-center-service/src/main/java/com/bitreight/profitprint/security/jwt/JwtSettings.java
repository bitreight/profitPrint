package com.bitreight.profitprint.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author bitreight
 */
@Configuration
@ConfigurationProperties(prefix = "security.jwt")
@Data
public class JwtSettings {
    private String signingKey;
    private Integer expirationTime;
}
