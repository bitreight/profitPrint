package com.bitreight.profitprint.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;

import javax.security.auth.Subject;

/**
 * @author bitreight
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private String jwtToken;
    private AuthenticatedUser authenticatedUser;

    public JwtAuthenticationToken(String jwtToken) {
        super(null);
        this.jwtToken = jwtToken;
        setAuthenticated(false);
    }

    public JwtAuthenticationToken(String jwtToken, AuthenticatedUser authenticatedUser) {
        super(authenticatedUser.getAuthorities());
        this.jwtToken = jwtToken;
        this.authenticatedUser = authenticatedUser;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return jwtToken;
    }

    @Override
    public Object getPrincipal() {
        return authenticatedUser;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
