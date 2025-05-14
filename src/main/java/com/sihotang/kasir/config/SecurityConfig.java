package com.sihotang.kasir.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/users/**").hasRole("ADMIN")
                .requestMatchers("/api/v1/roles/**").hasRole("ADMIN")
                .requestMatchers("/api/v1/stores/**").hasAnyRole("ADMIN", "STORE_ADMIN")
                .requestMatchers("/api/v1/stock-items/**").hasAnyRole("ADMIN", "STORE_ADMIN", "CASHIER")
                .requestMatchers("/api/v1/transactions/**").hasAnyRole("ADMIN", "STORE_ADMIN", "CASHIER")
                .anyRequest().authenticated()
            )
            .httpBasic();
        return http.build();
    }
} 