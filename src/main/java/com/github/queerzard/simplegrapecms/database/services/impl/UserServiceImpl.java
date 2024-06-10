package com.github.queerzard.simplegrapecms.database.services.impl;

import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import com.github.queerzard.simplegrapecms.database.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public List<GrapeUserEntity> findAll() {
        return List.of();
    }

    @Override
    public List<GrapeUserEntity> findAllEnabled() {
        return List.of();
    }

    @Override
    public GrapeUserEntity findUserById(String id) {
        return null;
    }

    @Override
    public GrapeUserEntity findUserByEmail(String email) {
        return null;
    }

    @Override
    public GrapeUserEntity findUserByName(String username) {
        return null;
    }

    @Override
    public void delete(GrapeUserEntity userEntity) {

    }

    @Override
    public boolean exists(GrapeUserEntity userEntity) {
        return false;
    }

    @Override
    public GrapeUserEntity update(GrapeUserEntity userEntity) {
        return null;
    }

    @Override
    public GrapeUserEntity save(GrapeUserEntity userEntity) {
        return null;
    }

    @Override
    public GrapeUserEntity add(GrapeUserEntity userEntity) {
        return null;
    }

    @Override
    public GrapeUserEntity addIfNotExists(GrapeUserEntity userEntity) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
