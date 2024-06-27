//package com.example.wallet_service.security;
//
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SpringSecurityConfig {
//
//    // add support for JDBC ... no more hardcoded users :-)
//
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        // define query to retrieve a user by username
//        jdbcUserDetailsManager.setUsersByUsernameQuery(
//                "select id, username, mobile_number, national_id, email, password from user where id=?");
//
//        // define query to retrieve the authorities/roles by username
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
//                "select user_id, role from roles where user_id=?");
//
//        return jdbcUserDetailsManager;
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/users/**").permitAll() // Allow public access to specific endpoints
//                                .anyRequest().authenticated() // Require authentication for any other request
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login") // Custom login page
//                                .permitAll()
//                )
//                .logout(logout ->
//                        logout.permitAll()
//                );
//
//        return http.build();
//    }
//
//
//
//
//}