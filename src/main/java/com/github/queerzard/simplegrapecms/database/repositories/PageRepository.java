package com.github.queerzard.simplegrapecms.database.repositories;

import com.github.queerzard.simplegrapecms.database.dto.CustomPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<CustomPageEntity, Long> {
    CustomPageEntity findCustomPageEntityByContext(String context);
    CustomPageEntity findCustomPageEntityByName(String name);
    CustomPageEntity findCustomPageEntityById(String id);

    List<CustomPageEntity> findCustomPageEntitiesByCreator_Username(String username);
    List<CustomPageEntity> findCustomPageEntitiesByCreator_Email(String email);
    List<CustomPageEntity> findCustomPageEntitiesByPublishedTrue();
    List<CustomPageEntity> findCustomPageEntitiesByEditableTrue();
    List<CustomPageEntity> findCustomPageEntitiesByPublishedFalseAndEditableFalse();
    List<CustomPageEntity> findCustomPageEntitiesByPublishedFalseAndEditableTrue();
    List<CustomPageEntity> findCustomPageEntitiesByPublishedTrueAndEditableFalse();


    boolean existsCustomPageEntityByContext(String context);
    boolean existsCustomPageEntityById(String id);
    boolean existsCustomPageEntityByName(String name);
}
