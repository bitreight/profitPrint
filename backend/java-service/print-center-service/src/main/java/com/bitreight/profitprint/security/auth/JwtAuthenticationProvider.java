package com.bitreight.profitprint.security.auth;

import com.bitreight.profitprint.security.jwt.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author bitreight
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String jwtToken = (String) authentication.getCredentials();

        Pair<String, AuthenticatedUser> successfulAuth;
        try {
            successfulAuth = jwtTokenService.parseToken(jwtToken);
        } catch (Exception e) {
            throw new AuthenticationServiceException("Token is invalid, malformed or expired", e);
        }

        return new JwtAuthenticationToken(successfulAuth.getFirst(), successfulAuth.getSecond());
    }

    @Override
    public boolean supports(Class<?> authClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(authClass);
    }
}
