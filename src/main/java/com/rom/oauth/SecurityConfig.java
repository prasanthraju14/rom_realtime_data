
/*
package com.rom.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/login", "/oauth/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                    .userService(oauthUserService);
    }
     
    @Autowired
    private CustomOAuth2UserService oauthUserService;
     
 
}


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and()
              .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user/info", "/rom/**")
                  .hasAuthority("SCOPE_read")
                .antMatchers(HttpMethod.POST, "/rom")
                  .hasAuthority("SCOPE_write")
                .anyRequest()
                  .authenticated()
            .and()
              .oauth2ResourceServer()
                .jwt();
    }
}

*/