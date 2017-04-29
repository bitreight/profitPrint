package com.bitreight.profitprint.security.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bitreight on 4/28/17.
 */
public class JwtTokenAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    public JwtTokenAuthenticationProcessingFilter(String processingUrl) {
        super(processingUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null;
    }


}
