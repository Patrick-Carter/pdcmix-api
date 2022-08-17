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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", nullable = true)
    private UserEntity createdBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_by", nullable = true)
    private UserEntity updatedBy;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime updatedAt;

    @Column(nullable = false)
    private Boolean open;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<DiscussionEntity> discussions;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<UserProjectPermissionLink> userProjectPermissionLinks;

    @ManyToMany(mappedBy = "projects")
    private Set<FileEntity> files;

    public Set<UserProjectPermissionLink> getUserProjectPermissionLinks() {
        return userProjectPermissionLinks;
    }

    public void setUserProjectPermissionLinks(Set<UserProjectPermissionLink> userProjectPermissionLinks) {
        this.userProjectPermissionLinks = userProjectPermissionLinks;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public Set<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(Set<FileEntity> files) {
        this.files = files;
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

    public Set<DiscussionEntity> getDiscussions() {
        return discussions;
    }

    public void setDiscussions(Set<DiscussionEntity> discussions) {
        this.discussions = discussions;
    }
}
