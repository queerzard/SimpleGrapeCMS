package com.github.queerzard.simplegrapecms.config.security;

import com.github.queerzard.simplegrapecms.database.services.auth.GrapeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Order(value = -1)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class GrapeSecurityConfig {

    private final GrapeAuthenticationProvider authenticationProvider;

    @Autowired
    private GrapeUserDetailsService userDetailsService;

    @Autowired
    public GrapeSecurityConfig(GrapeAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((registry) -> {
                    registry
                            .requestMatchers(HttpMethod.DELETE).hasRole("ROLE_ADMIN")
                            .requestMatchers(
                                    "/",
                                    "/home",
                                    "/login"
                            ).permitAll()

                            .requestMatchers(
                                    "/logout"
                            ).authenticated()

                            .anyRequest()
                            .authenticated()
                    ;
                })

                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionConfigurer -> {
                    sessionConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return this.userDetailsService;
    }
/*

    @Bean
    public AuthenticationManager authenticationManager(){
        return new AuthenticationManagerBuilder().authenticationProvider(this.authenticationProvider).build();
    }
*/


}
