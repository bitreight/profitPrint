package com.bitreight.profitprint.security.auth;

import com.bitreight.profitprint.security.jwt.JwtTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bitreight on 4/28/17.
 */
public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private ObjectMapper mapper;

    public AjaxLoginProcessingFilter(String processingUrl) {
        super(processingUrl);

        this.setAuthenticationSuccessHandler((rq, rs, auth) -> {
            if(auth.getPrincipal() instanceof UserDetails) {
                Pair<String, String> token = jwtTokenService.createToken((UserDetails) auth.getPrincipal());
                rs.setStatus(HttpStatus.OK.value());
                rs.setContentType(MediaType.APPLICATION_JSON_VALUE);
                mapper.writeValue(rs.getWriter(), token);
            }
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        if (!HttpMethod.POST.matches(request.getMethod())) {
            throw new AuthenticationServiceException("Authentication method not supported");
        }

        LoginJsonObject loginJson = mapper.readValue(request.getReader(), LoginJsonObject.class);

        if (StringUtils.isBlank(loginJson.getLogin()) || StringUtils.isBlank(loginJson.getPassword())) {
            throw new BadCredentialsException("Username or Password not provided");
        }

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginJson.getLogin(), loginJson.getPassword());

//        tmp in memory auth
        return this.getAuthenticationManager().authenticate(token);
    }

    @Data
    private static class LoginJsonObject {
        private String login;
        private String password;
    }
}
