package com.github.queerzard.simplegrapecms.database.dto.user;


import com.github.queerzard.simplegrapecms.database.dto.AbstractEntity;
import com.github.queerzard.simplegrapecms.database.dto.CustomPageEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "users")
public class GrapeUserEntity extends AbstractEntity {

    @Getter @Setter private String email;
    @Getter @Setter private String username;
    @Getter @Setter private String password;

    @Getter @Setter private boolean enabled;
    @Getter @Setter private boolean locked;
    @Getter @Setter private boolean credentialsExpired;
    @Getter @Setter private boolean accountExpired;

    @OneToMany(mappedBy = "creator")
    @Getter @Setter private Collection<CustomPageEntity> pages;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @Getter private Collection<RoleEntity> roles;

    public GrapeUserEntity() {}

    public GrapeUserEntity(String email, String username, String password, boolean enabled, boolean locked, boolean credentialsExpired, boolean accountExpired) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.locked = locked;
        this.credentialsExpired = credentialsExpired;
        this.accountExpired = accountExpired;

    }


}
