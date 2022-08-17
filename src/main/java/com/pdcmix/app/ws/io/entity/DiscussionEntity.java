package com.pdcmix.app.ws.io.entity;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.links.UserDiscussionPermissionLink;

@Entity(name = "discussion")
@Table(name = "discussions")
public class DiscussionEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private UUID createdBy;

    @Column(nullable = false)
    private UUID updatedBy;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()")
    private ZonedDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()")
    private ZonedDateTime updatedAt;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean open;

    @Column(nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private Set<CommentEntity> comments;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private Set<UserDiscussionPermissionLink> userDiscussionPermissionLinks;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileEntity file;

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public FileEntity getFile() {
        return file;
    }

    public void setFile(FileEntity file) {
        this.file = file;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<UserDiscussionPermissionLink> getUserDiscussionPermissionLinks() {
        return userDiscussionPermissionLinks;
    }

    public void setUserDiscussionPermissionLinks(Set<UserDiscussionPermissionLink> userDiscussionPermissionLinks) {
        this.userDiscussionPermissionLinks = userDiscussionPermissionLinks;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }
}
