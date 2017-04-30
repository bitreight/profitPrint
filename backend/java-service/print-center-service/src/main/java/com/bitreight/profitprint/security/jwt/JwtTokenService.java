package com.bitreight.profitprint.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

/**
 * Created by bitreight on 4/29/17.
 */
@Component
public class JwtTokenService {

    private JwtSettings jwtSettings;

    private final String SECRET_KEY;

    @Autowired
    public JwtTokenService(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
        SECRET_KEY = Base64.getEncoder().encodeToString(jwtSettings.getSigningKey().getBytes());
    }

    public Pair<String, String> createToken(UserDetails userDetails) {
        LocalDateTime currentTime = now();

        String token =
                Jwts.builder()
                    .claim("USER_ID", userDetails.getUsername())
                    .claim("ROLES", userDetails.getAuthorities().stream().map(Object::toString).collect(Collectors.toList()))
                    .setIssuedAt(Date.from(currentTime
                                    .atZone(ZoneId.systemDefault()).toInstant()))
                    .setExpiration(Date.from(currentTime.plusMinutes(jwtSettings.getExpirationTime())
                                    .atZone(ZoneId.systemDefault()).toInstant()))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();

        return Pair.of("token", token);
    }

    public org.springframework.data.util.Pair<String, User> parseToken(String jwtToken) {
        return org.springframework.data.util.Pair.of(null, null);
    }
}
