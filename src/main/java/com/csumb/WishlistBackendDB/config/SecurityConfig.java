package com.csumb.WishlistBackendDB.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/users/login", "/users/add").permitAll() // Allow public access to these endpoints
                        .anyRequest().authenticated() // Require authentication for other requests
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/users/login", "/users/add") // Disable CSRF for these endpoints
                );


        return http.build();
    }
}
