package com.github.queerzard.simplegrapecms.config.security;

import com.github.queerzard.simplegrapecms.database.services.auth.GrapeUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Order(value = -1)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class GrapeSecurityConfig {

    private final GrapeAuthenticationProvider authenticationProvider;

    @Autowired
    public SessionRegistry sessionRegistry;

    @Autowired
    private GrapeUserDetailsService userDetailsService;

    @Autowired
    public GrapeSecurityConfig(GrapeAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(csrf -> csrf.ignoringRequestMatchers("/api/v1/**", "/register"))
                .authorizeHttpRequests((registry) -> {
                    registry

                            .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")

                            .requestMatchers(
                                    "/",
                                    "/home",
                                    "/login",
                                    "/assets/**"
                            ).permitAll()

                            .requestMatchers(
                                    "/logout"
                            ).authenticated()

                            .anyRequest()
                            .authenticated()
                    ;
                })

                .formLogin(form ->
                        form
                                .loginPage("/login").permitAll())
                .logout(logout ->
                        logout
                                .logoutUrl("/logout").permitAll()
                                .logoutSuccessUrl("/login?logout")
                                .clearAuthentication(true)
                                .permitAll())

                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionConfigurer -> {
                    sessionConfigurer
                            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                            .maximumSessions(1)
                            .expiredUrl("/login?expired")
                            .sessionRegistry(this.sessionRegistry);
                });

        return httpSecurity.build();
    }

    @Bean
    public GrapeUserDetailsService userDetailsService() {
        return this.userDetailsService;
    }

    @Autowired
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        return auth.authenticationProvider(this.authenticationProvider).build();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
