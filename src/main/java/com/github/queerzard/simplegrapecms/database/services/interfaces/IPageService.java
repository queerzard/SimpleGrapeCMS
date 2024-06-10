package com.github.queerzard.simplegrapecms.database.services.interfaces;

import com.github.queerzard.simplegrapecms.database.dto.CustomPageEntity;
import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;

import java.util.List;

public interface IPageService {

    List<CustomPageEntity> findAll();
    List<CustomPageEntity> findByCreator(GrapeUserEntity grapeUserEntity);
    List<CustomPageEntity> findAllPublished();
    List<CustomPageEntity> findAllUnpublished();

    boolean existsByContext(String context);
    boolean existsByName(String name);
    boolean existsById(String id);

    long count();

}
