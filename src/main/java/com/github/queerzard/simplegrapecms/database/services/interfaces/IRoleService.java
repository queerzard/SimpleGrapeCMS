package com.github.queerzard.simplegrapecms.database.services.interfaces;

import com.github.queerzard.simplegrapecms.database.dto.user.PermissionEntity;
import com.github.queerzard.simplegrapecms.database.dto.user.RoleEntity;

import javax.management.relation.Role;
import java.util.List;

public interface IRoleService {

    List<RoleEntity> findAll();

    RoleEntity findByName(String name);
    void delete(RoleEntity entity);
    RoleEntity save(RoleEntity entity);
    RoleEntity update(RoleEntity entity);
    RoleEntity add(RoleEntity entity);
    RoleEntity addIfNotExists(RoleEntity entity);
    RoleEntity addPrivilege(RoleEntity r, PermissionEntity permissionEntity);
    RoleEntity removePrivilege(RoleEntity r, PermissionEntity permissionEntity);

    boolean exists(String roleName);
    long count();
}
