package com.github.queerzard.simplegrapecms.database.services.interfaces;

import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;

import java.util.List;

public interface IUserService {

    List<GrapeUserEntity> findAll();
    List<GrapeUserEntity> findAllEnabled();

    GrapeUserEntity findUserById(String id);
    GrapeUserEntity findUserByEmail(String email);
    GrapeUserEntity findUserByName(String username);

    void delete(GrapeUserEntity userEntity);
    boolean exists(GrapeUserEntity userEntity);
    GrapeUserEntity update(GrapeUserEntity userEntity);

    GrapeUserEntity save(GrapeUserEntity userEntity);
    GrapeUserEntity add(GrapeUserEntity userEntity);
    GrapeUserEntity addIfNotExists(GrapeUserEntity userEntity);

    long count();
}
