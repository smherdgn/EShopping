package com.indbilisim.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by semih on 05.07.2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests().antMatchers("/viewer/**", "api/**").permitAll().and()
                .authorizeRequests().antMatchers("/error").permitAll().and()
                .authorizeRequests().antMatchers("/resources/**").permitAll().and()
                .formLogin().loginPage("/index").permitAll()
                .loginProcessingUrl("/user/welcome")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/shop/exit"));

    }
}