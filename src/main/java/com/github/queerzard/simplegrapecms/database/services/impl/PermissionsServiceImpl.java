package com.github.queerzard.simplegrapecms.database.services.impl;

import com.github.queerzard.simplegrapecms.database.dto.user.PermissionEntity;
import com.github.queerzard.simplegrapecms.database.repositories.PermissionRepository;
import com.github.queerzard.simplegrapecms.database.services.interfaces.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionsServiceImpl implements IPermissionService {

    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionEntity> findAll() {
        return this.permissionRepository.findAll();
    }

    @Override
    public PermissionEntity findByName(String name) {
        return this.permissionRepository.findPermissionEntityByPermissionName(name);
    }

    @Override
    public void delete(PermissionEntity entity) {
        this.permissionRepository.delete(entity);
    }

    @Override
    public PermissionEntity save(PermissionEntity entity) {
        return this.permissionRepository.save(entity);
    }

    @Override
    public PermissionEntity update(PermissionEntity entity) {
        return this.permissionRepository.save(entity);
    }

    @Override
    public PermissionEntity add(PermissionEntity entity) {
        return this.permissionRepository.save(entity);
    }

    @Override
    public PermissionEntity addIfNotExists(PermissionEntity entity) {
        return (exists(entity.getPermissionName()) ? null : add(entity));
    }

    @Override
    public boolean exists(String roleName) {
        return this.permissionRepository.existsPermissionEntityByPermissionName(roleName);
    }

    @Override
    public long count() {
        return this.permissionRepository.count();
    }
}
