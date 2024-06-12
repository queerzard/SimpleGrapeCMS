package com.github.queerzard.simplegrapecms.config.security;

import com.github.queerzard.simplegrapecms.database.services.auth.GrapeUserDetails;
import com.github.queerzard.simplegrapecms.database.services.auth.GrapeUserDetailsService;
import com.github.queerzard.simplegrapecms.database.services.impl.UserServiceImpl;
import com.github.queerzard.simplegrapecms.database.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class GrapeAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final GrapeUserDetailsService grapeUserDetailsService;
    @Autowired private final IUserService userService;

    public GrapeAuthenticationProvider(GrapeUserDetailsService grapeUserDetailsService, IUserService iUserService) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.grapeUserDetailsService = grapeUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (authentication.getCredentials().toString());

        GrapeUserDetails grapeUserDetails = (GrapeUserDetails) grapeUserDetailsService.loadUserByUsername(username);

        if (grapeUserDetails == null)
            throw new UsernameNotFoundException("User not found");

        if (!passwordEncoder.matches(password, grapeUserDetails.getPassword()))
            throw new AuthenticationException("Invalid credentials") {};

        if(!grapeUserDetails.isEnabled())
            throw new AuthenticationException("Account Disabled") {};

        if(!grapeUserDetails.isAccountNonExpired())
            throw new AuthenticationException("Account has expired") {};

        if(!grapeUserDetails.isAccountNonLocked())
            throw new AuthenticationException("Account is locked") {};

        if(!grapeUserDetails.isCredentialsNonExpired())
            throw new AuthenticationException("Account credentials have expired") {};

        Authentication authenticated = new UsernamePasswordAuthenticationToken(
                grapeUserDetails, null, grapeUserDetails.getAuthorities());
        return authenticated;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
