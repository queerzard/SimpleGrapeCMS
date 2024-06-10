package com.github.queerzard.simplegrapecms.database.repositories;

import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<GrapeUserEntity, Long> {

    GrapeUserEntity findGrapeUserEntityByUsername(String username);
    GrapeUserEntity findGrapeUserEntityByEmail(String email);
    GrapeUserEntity findGrapeUserEntityById(String id);

    List<GrapeUserEntity> findGrapeUserEntitiesByEnabledIsTrue();
    List<GrapeUserEntity> findGrapeUserEntityByTokenExpiredIsTrue();

    boolean existsGrapeUserEntityByEmail(String email);
    boolean existsGrapeUserEntityByUsername(String username);
}
