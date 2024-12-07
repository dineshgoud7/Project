package com.studentfeedback.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/faculty/**").hasRole("FACULTY")
                .requestMatchers("/api/student/**").hasRole("STUDENT")
                .anyRequest().authenticated()
            )
            .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userBuilder = User.withDefaultPasswordEncoder();  // Default password encoder (For testing)
        
        // Defining in-memory users
        UserDetails admin = userBuilder
            .username("admin")
            .password("admin123")
            .roles("ADMIN")
            .build();
        
        UserDetails faculty = userBuilder
            .username("faculty")
            .password("faculty123")
            .roles("FACULTY")
            .build();
        
        UserDetails student = userBuilder
            .username("student")
            .password("student123")
            .roles("STUDENT")
            .build();
        
        // Returning an in-memory user manager with the defined users
        return new InMemoryUserDetailsManager(admin, faculty, student);
    }
}
