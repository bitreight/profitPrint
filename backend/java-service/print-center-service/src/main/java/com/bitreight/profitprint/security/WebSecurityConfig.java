package com.bitreight.profitprint.security;

import com.bitreight.profitprint.security.auth.AjaxLoginProcessingFilter;
import com.bitreight.profitprint.security.auth.JwtAuthenticationProvider;
import com.bitreight.profitprint.security.auth.RepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;

/**
 * Created by bitreight on 4/27/17.
 */
//TODO: configure JWT auth to secured endpoints
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RepositoryUserDetailsService repositoryUserDetailsService;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().withUser("user").password("pass");
//                .authenticationProvider(ajaxAuthenticationProvider())
//                .authenticationProvider(jwtAuthenticationProvider);
    }

    @Bean
    public DaoAuthenticationProvider ajaxAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(repositoryUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    protected Filter getAjaxLoginProcessingFilter() throws Exception {
        AjaxLoginProcessingFilter filter = new AjaxLoginProcessingFilter("/auth/login");
        filter.setAuthenticationManager(authenticationManagerBean());

        // create token, put in response
//        filter.setAuthenticationSuccessHandler((rq, rs, auth) -> {
//            if(auth.getPrincipal() instanceof UserDetails) {
//                String token = jwtTokenService().createToken(auth.getPrincipal());
//                rs.addHeader("token", token);
//            }
//        });

        return filter;
    }

//    protected Filter getJwtTokenAuthenticationProcessingFilter() {
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(new Http401AuthenticationEntryPoint("Bearer realm=\"users\""))

        .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        .and()
            .authorizeRequests()
            .antMatchers("/auth/login").permitAll()
            .anyRequest().authenticated()

        .and()
            .addFilterBefore(getAjaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
//            .addFilterBefore(getJwtTokenAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
