package com.guarderia.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {
            "/api/v1/**",
            "/api/v1/auth/**",
            "/webjars/**",
            "/",
            "/view/**",
            "/login.html",
            "/dashboard.html",
            "/main.css",
            "/js/auth.js",
            "/img/**",
            "/about.html",
            "/about"
    };

    private final AuthenticationProvider authenticationProvider;
//    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->{
                        req.requestMatchers(WHITE_LIST_URL).permitAll();
                        req.anyRequest().authenticated();
                    })
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login")
                            .permitAll()
                            .defaultSuccessUrl("/dashboard", true);
                })
                .authenticationProvider(authenticationProvider)
        ;

        return httpSecurity.build();
    }

}
