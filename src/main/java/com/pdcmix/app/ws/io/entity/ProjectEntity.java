package com.pdcmix.app.ws.io.entity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "project")
@Table(name = "projects")
public class ProjectEntity {
    
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Column(columnDefinition = "boolean default true NOT NULL")
    private Boolean status;

    @Column(columnDefinition = "integer default 0 not null")
    private Integer revisions;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "updated_by")
    private UserEntity updatedBy;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime updatedAt;

    @Column(nullable = false)
    private Boolean open;

    @Column()
    private List<DiscussionEntity> discussions;

    @Column()
    private List<FileEntity> projectFiles;

    @Column()
    private List<PermissionEntity> permissions;

    @Column()
    private List<CriteriaEntity> criteria;

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public UserEntity getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserEntity updatedBy) {
        this.updatedBy = updatedBy;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRevisions() {
        return revisions;
    }

    public void setRevisions(Integer revisions) {
        this.revisions = revisions;
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

    public List<DiscussionEntity> getDiscussions() {
        return discussions;
    }

    public void setDiscussions(List<DiscussionEntity> discussions) {
        this.discussions = discussions;
    }

    public List<FileEntity> getProjectFiles() {
        return projectFiles;
    }

    public void setProjectFiles(List<FileEntity> projectFiles) {
        this.projectFiles = projectFiles;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public List<CriteriaEntity> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<CriteriaEntity> criteria) {
        this.criteria = criteria;
    }
}
