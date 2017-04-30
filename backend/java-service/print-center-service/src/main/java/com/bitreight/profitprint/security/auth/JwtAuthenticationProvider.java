package com.bitreight.profitprint.security.auth;

import com.bitreight.profitprint.security.jwt.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by bitreight on 4/28/17.
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String jwtToken = (String) authentication.getCredentials();

        Pair<String, User> successfulAuth = jwtTokenService.parseToken(jwtToken);

        return new JwtAuthenticationToken(successfulAuth.getFirst(), successfulAuth.getSecond());
    }

    @Override
    public boolean supports(Class<?> authClass) {
        return JwtAuthenticationToken.class.isAssignableFrom(authClass);
    }
}
