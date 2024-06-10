package com.github.queerzard.simplegrapecms.database.services.impl;

import com.github.queerzard.simplegrapecms.database.dto.CustomPageEntity;
import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import com.github.queerzard.simplegrapecms.database.services.interfaces.IPageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements IPageService {
    @Override
    public List<CustomPageEntity> findAll() {
        return List.of();
    }

    @Override
    public List<CustomPageEntity> findByCreator(GrapeUserEntity grapeUserEntity) {
        return List.of();
    }

    @Override
    public List<CustomPageEntity> findAllPublished() {
        return List.of();
    }

    @Override
    public List<CustomPageEntity> findAllUnpublished() {
        return List.of();
    }

    @Override
    public boolean existsByContext(String context) {
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }
}
