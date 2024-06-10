package com.github.queerzard.simplegrapecms.database.repositories;

import com.github.queerzard.simplegrapecms.database.dto.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findRoleEntityById(String id);
    RoleEntity findRoleEntityByRoleName(String roleName);

    boolean existsRoleEntityByRoleName(String name);

}
