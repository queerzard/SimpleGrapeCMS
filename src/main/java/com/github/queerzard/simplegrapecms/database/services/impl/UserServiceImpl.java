package com.github.queerzard.simplegrapecms.database.services.impl;

import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import com.github.queerzard.simplegrapecms.database.repositories.UserRepository;
import com.github.queerzard.simplegrapecms.database.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public List<GrapeUserEntity> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public List<GrapeUserEntity> findAllEnabled() {
        return this.userRepository.findGrapeUserEntitiesByEnabledIsTrue();
    }

    @Override
    public GrapeUserEntity findUserById(String id) {
        return this.userRepository.findGrapeUserEntityById(id);
    }

    @Override
    public GrapeUserEntity findUserByEmail(String email) {
        return this.userRepository.findGrapeUserEntityByEmail(email);
    }

    @Override
    public GrapeUserEntity findUserByName(String username) {
        return this.userRepository.findGrapeUserEntityByUsername(username);
    }

    @Override
    public void delete(GrapeUserEntity userEntity) {
        this.userRepository.delete(userEntity);
    }

    @Override
    public boolean exists(GrapeUserEntity userEntity) {
        return this.userRepository.existsGrapeUserEntityByUsername(userEntity.getUsername());
    }

    @Override
    public GrapeUserEntity update(GrapeUserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public GrapeUserEntity save(GrapeUserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public GrapeUserEntity add(GrapeUserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public GrapeUserEntity addIfNotExists(GrapeUserEntity userEntity) {
        return (!exists(userEntity) ? this.userRepository.save(userEntity) : null);
    }

    @Override
    public long count() {
        return this.userRepository.count();
    }
}
