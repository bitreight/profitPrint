package com.bitreight.profitprint.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bitreight on 4/29/17.
 */
@Configuration
@ConfigurationProperties(prefix = "security.jwt")
@Data
public class JwtSettings {
    private String signingKey;
    private Integer expirationTime;
}
