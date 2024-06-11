package com.github.queerzard.simplegrapecms.database.services.impl;

import com.github.queerzard.simplegrapecms.database.dto.user.PermissionEntity;
import com.github.queerzard.simplegrapecms.database.dto.user.RoleEntity;
import com.github.queerzard.simplegrapecms.database.repositories.RoleRepository;
import com.github.queerzard.simplegrapecms.database.services.interfaces.IRoleService;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    private RoleRepository roleRepository;

    @Override
    public List<RoleEntity> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public RoleEntity findByName(String name) {
        return this.roleRepository.findRoleEntityByRoleName(name);
    }

    @Override
    public void delete(RoleEntity entity) {
        this.roleRepository.delete(entity);
    }

    @Override
    public RoleEntity save(RoleEntity entity) {
        return this.roleRepository.save(entity);
    }

    @Override
    public RoleEntity update(RoleEntity entity) {
        return this.roleRepository.save(entity);
    }

    @Override
    public RoleEntity add(RoleEntity entity) {
        return this.roleRepository.save(entity);
    }

    @Override
    public RoleEntity addIfNotExists(RoleEntity entity) {
        return (exists(entity.getRoleName()) ? null : add(entity));
    }

    @Override
    public RoleEntity addPrivilege(RoleEntity roleEntity, PermissionEntity permissionEntity) {
        roleEntity.getPermissions().add(permissionEntity);
        return update(roleEntity);
    }

    @Override
    public RoleEntity removePrivilege(RoleEntity r, PermissionEntity permissionEntity) {
        RoleEntity roleEntity = r;
        PermissionEntity entityMatch = null;
        try {entityMatch = roleEntity.getPermissions().stream().filter((permission) -> permission.getPermissionName()
                    .equalsIgnoreCase(permissionEntity.getPermissionName())).findFirst().get();} catch (NullPointerException e){}

        if(entityMatch != null){
            r.getPermissions().remove(entityMatch);
            this.save(r);
        }

        return (entityMatch == null ? null : r);
    }

    @Override
    public boolean exists(String roleName) {
        return this.roleRepository.existsRoleEntityByRoleName(roleName);
    }

    @Override
    public long count() {
        return this.roleRepository.count();
    }
}
