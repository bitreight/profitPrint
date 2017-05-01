package com.bitreight.profitprint.security.jwt;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author bitreight
 */
@Component
public class JwtTokenExtractor {

    private static final String TOKEN_HEADER_NAME = "Authorization";
    private static final String BEARER = "Bearer ";

    public Optional<String> extract(HttpServletRequest request) {
        Optional<String> tokenHeader = Optional.ofNullable(request.getHeader(TOKEN_HEADER_NAME));
        if (!tokenHeader.isPresent() || !tokenHeader.get().startsWith(BEARER)) {
            return Optional.empty();
        }

        String token = tokenHeader.get().substring(BEARER.length(), tokenHeader.get().length());
        return token.isEmpty() ? Optional.empty() : Optional.of(token);
    }
}
