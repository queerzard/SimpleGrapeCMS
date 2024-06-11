package com.github.queerzard.simplegrapecms.database.services.impl;

import com.github.queerzard.simplegrapecms.database.dto.CustomPageEntity;
import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import com.github.queerzard.simplegrapecms.database.repositories.PageRepository;
import com.github.queerzard.simplegrapecms.database.services.interfaces.IPageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements IPageService {

    private PageRepository pageRepository;

    @Override
    public List<CustomPageEntity> findAll() {
        return this.pageRepository.findAll();
    }

    @Override
    public List<CustomPageEntity> findByCreator(GrapeUserEntity grapeUserEntity) {
        return this.pageRepository.findCustomPageEntitiesByCreator_Email(grapeUserEntity.getEmail());
    }

    @Override
    public List<CustomPageEntity> findAllPublished() {
        return this.pageRepository.findCustomPageEntitiesByPublishedTrueAndEditableFalse();
    }

    @Override
    public List<CustomPageEntity> findAllUnpublished() {
        return this.pageRepository.findCustomPageEntitiesByPublishedFalseAndEditableTrue();
    }

    @Override
    public boolean existsByContext(String context) {
        return this.pageRepository.existsCustomPageEntityByContext(context);
    }

    @Override
    public boolean existsByName(String name) {
        return this.pageRepository.existsCustomPageEntityByName(name);
    }

    @Override
    public boolean existsById(String id) {
        return this.pageRepository.existsCustomPageEntityById(id);
    }

    @Override
    public long count() {
        return this.pageRepository.count();
    }
}
