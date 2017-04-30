package com.bitreight.profitprint.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import javax.security.auth.Subject;

/**
 * Created by bitreight on 4/30/17.
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private String jwtToken;
    private UserDetails userDetails;

    public JwtAuthenticationToken(String jwtToken) {
        super(null);
        this.jwtToken = jwtToken;
        setAuthenticated(false);
    }

    public JwtAuthenticationToken(String jwtToken, UserDetails userDetails) {
        super(userDetails.getAuthorities());
        this.jwtToken = jwtToken;
        this.userDetails = userDetails;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return jwtToken;
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
