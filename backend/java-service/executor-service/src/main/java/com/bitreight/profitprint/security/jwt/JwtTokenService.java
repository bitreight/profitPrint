package com.bitreight.profitprint.security.jwt;

import com.bitreight.profitprint.security.auth.AuthenticatedUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

/**
 * @author bitreight
 */
@Component
@SuppressWarnings("unchecked")
public class JwtTokenService {

    private JwtSettings jwtSettings;

    private final String SECRET_KEY;

    private static final String USER_ID = "USER_ID";
    private static final String USER_LOGIN = "USER_LOGIN";
    private static final String ROLES = "ROLES";

    @Autowired
    public JwtTokenService(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
        SECRET_KEY = Base64.getEncoder().encodeToString(jwtSettings.getSigningKey().getBytes());
    }

    public Pair<String, String> createToken(AuthenticatedUser authenticatedUser) {
        LocalDateTime currentTime = now();

        String token =
                Jwts.builder()
                    .claim(USER_ID, authenticatedUser.getId())
                    .claim(USER_LOGIN, authenticatedUser.getUsername())
                    .claim(ROLES, authenticatedUser.getAuthorities().stream().map(Object::toString).collect(Collectors.toList()))
                    .setIssuedAt(Date.from(currentTime
                                    .atZone(ZoneId.systemDefault()).toInstant()))
                    .setExpiration(Date.from(currentTime.plusMinutes(jwtSettings.getExpirationTime())
                                    .atZone(ZoneId.systemDefault()).toInstant()))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();

        return Pair.of("token", token);
    }

    public org.springframework.data.util.Pair<String, AuthenticatedUser> parseToken(String jwtToken) {
        Claims jwtClaims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwtToken).getBody();

        AuthenticatedUser authenticatedUser = new AuthenticatedUser()
                .setId(Long.valueOf(jwtClaims.get(USER_ID, Integer.class)))
                .setLogin(jwtClaims.get(USER_LOGIN, String.class))
                .setAuthorities(((List<String>) jwtClaims.get(ROLES, List.class)).stream()
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(Collectors.toList()));

        return org.springframework.data.util.Pair.of(jwtToken, authenticatedUser);
    }
}
