package com.github.queerzard.simplegrapecms.database.repositories;

import com.github.queerzard.simplegrapecms.database.dto.user.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    PermissionEntity findPermissionEntityById(String id);
    PermissionEntity findPermissionEntityByPermissionName(String name);
    boolean existsPermissionEntityByPermissionName(String name);

}
