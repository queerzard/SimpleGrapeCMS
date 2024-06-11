package com.github.queerzard.simplegrapecms.database.services.auth;

import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class GrapeUserDetails implements UserDetails {

    @Getter private GrapeUserEntity grapeUserEntity;


    public GrapeUserDetails(GrapeUserEntity grapeUserEntity){
        this.grapeUserEntity = grapeUserEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        this.grapeUserEntity.getRoles().forEach((r) -> {
            GrantedAuthority grantedAuthorityR = new SimpleGrantedAuthority("ROLE_" + r.getRoleName().toLowerCase());
            grantedAuthorities.add(grantedAuthorityR);
            r.getPermissions().forEach((p) -> {
                GrantedAuthority grantedAuthorityP = new SimpleGrantedAuthority(p.getPermissionName());
                grantedAuthorities.add(grantedAuthorityP);
            });
        });

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.grapeUserEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.grapeUserEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.grapeUserEntity.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.grapeUserEntity.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.grapeUserEntity.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.grapeUserEntity.isEnabled();
    }
}
