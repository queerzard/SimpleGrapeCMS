package com.github.queerzard.simplegrapecms.database.services.interfaces;

import com.github.queerzard.simplegrapecms.database.dto.user.PermissionEntity;
import com.github.queerzard.simplegrapecms.database.dto.user.RoleEntity;

import java.util.List;

public interface IPermissionService {

    List<PermissionEntity> findAll();

    PermissionEntity findByName(String name);
    void delete(PermissionEntity entity);
    PermissionEntity save(PermissionEntity entity);
    PermissionEntity update(PermissionEntity entity);
    PermissionEntity add(PermissionEntity entity);
    PermissionEntity addIfNotExists(PermissionEntity entity);

    boolean exists(String roleName);
    long count();

}
