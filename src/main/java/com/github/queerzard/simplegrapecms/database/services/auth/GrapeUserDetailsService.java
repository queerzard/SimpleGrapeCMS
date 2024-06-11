package com.github.queerzard.simplegrapecms.database.services.auth;

import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import com.github.queerzard.simplegrapecms.database.repositories.UserRepository;
import com.github.queerzard.simplegrapecms.database.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GrapeUserDetailsService implements UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        GrapeUserEntity userEntity;
        if((userEntity = userRepository.findGrapeUserEntityByUsername(s)) == null && (userEntity = userRepository.findGrapeUserEntityByEmail(s)) == null)
            throw new UsernameNotFoundException("User not found with username/email: " +  s);
        return new GrapeUserDetails(userEntity);
    }

}
