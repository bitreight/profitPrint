package com.bitreight.profitprint.security.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
public class AjaxLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper mapper = new ObjectMapper();

    public AjaxLoginProcessingFilter(String processingUrl) {
        super(processingUrl);
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

    private static class LoginJsonObject {
        private String login;
        private String password;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}


