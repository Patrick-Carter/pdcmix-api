package com.pdcmix.app.ws.io.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "comment")
@Table(name = "comments")
public class CommentEntity {
    
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Boolean edited;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false, columnDefinition = "integer default 0 not null")
    private Integer likes;

    @Column(nullable = false)
    private String createdBy;
    
    @Column(nullable = false)
    private String updatedBy;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;
    
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime updatedAt;
}
