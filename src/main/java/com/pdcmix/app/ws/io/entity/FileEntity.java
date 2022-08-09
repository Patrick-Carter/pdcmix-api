package com.pdcmix.app.ws.io.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.enums.FileEnum;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name = "projectFile")
@Table(name = "project_files")
public class FileEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String bucket;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FileEnum type;

    @Column(nullable = false, columnDefinition = "integer default 0 not null")
    private Integer revisions;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String updatedBy;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime updatedAt;

    @Column()
    private List<CommentEntity> comments;

    @Column()
    private List<PermissionEntity> permissions;

    @Column()
    private List<CriteriaEntity> criteria;

}
