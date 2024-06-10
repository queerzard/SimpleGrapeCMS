package com.github.queerzard.simplegrapecms.database.dto.user;

import com.github.queerzard.simplegrapecms.database.dto.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "roles")
public class RoleEntity extends AbstractEntity {

    @Getter @Setter private String roleName;

    @ManyToMany(mappedBy = "roles")
    @Getter @Setter private Collection<GrapeUserEntity> users;

    @ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    @Getter @Setter private Collection<PermissionEntity> permissions;

}
