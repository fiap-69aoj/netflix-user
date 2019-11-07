package com.netflix.netflixuser.config;

import com.netflix.netflixuser.filter.JWTAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 31/10/2019 13:29
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/users").permitAll()
                .antMatchers(
                        "/actuator/**",
                        "/h2-console/**",
                        "/users/teste"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}