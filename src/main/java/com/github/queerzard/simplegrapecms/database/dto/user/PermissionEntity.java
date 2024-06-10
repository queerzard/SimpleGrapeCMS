package com.github.queerzard.simplegrapecms.database.dto.user;

import com.github.queerzard.simplegrapecms.database.dto.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "permissions")
public class PermissionEntity extends AbstractEntity {

    @Getter @Setter private String permissionName;
    @ManyToMany(mappedBy = "permissions")
    @Getter private Collection<RoleEntity> roles;

}
