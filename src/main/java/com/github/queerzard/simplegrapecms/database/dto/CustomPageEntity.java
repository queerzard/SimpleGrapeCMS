package com.github.queerzard.simplegrapecms.database.dto;

import com.github.queerzard.simplegrapecms.database.dto.user.GrapeUserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "pages")
@Entity
public class CustomPageEntity extends AbstractEntity {

    @Getter @Setter private String name;
    @Getter @Setter private String base64contents;
    @Getter @Setter private String accessRole;
    @Getter @Setter private String context;

    @Getter @Setter private long creationTimeStamp;

    @Getter @Setter private boolean published;
    @Getter @Setter private boolean editable;

    @Getter @Setter private GrapeUserEntity creator;

}

