package com.bitreight.profitprint.security.auth;

import com.bitreight.profitprint.security.jwt.JwtTokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author bitreight
 */
public class JwtTokenAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private JwtTokenExtractor jwtTokenExtractor;

    public JwtTokenAuthenticationProcessingFilter(String processingUrl) {
        super(processingUrl);
        super.setAuthenticationSuccessHandler((rq, rs, a) -> {});
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        Optional<String> token = jwtTokenExtractor.extract(request);
        if (!token.isPresent()) {
            throw new AuthenticationServiceException("No token provided in request header.");
        }

        return getAuthenticationManager().authenticate(new JwtAuthenticationToken(token.get()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
