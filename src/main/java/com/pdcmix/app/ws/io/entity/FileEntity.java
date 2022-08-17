package com.pdcmix.app.ws.io.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.enums.FileEnum;
import com.pdcmix.app.ws.io.links.UserFilePermissionLink;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "file")
@Table(name = "files")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", nullable = true)
    private UserEntity createdBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "updated_by", nullable = true)
    private UserEntity updatedBy;

    @Column(nullable = false)
    private Boolean open;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
    private Set<UserFilePermissionLink> userFilePermissionLinks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_files", joinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<ProjectEntity> projects;

    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL)
    private Set<DiscussionEntity> discussions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectEntity> projects) {
        this.projects = projects;
    }

    public Set<UserFilePermissionLink> getUserFilePermissionLinks() {
        return userFilePermissionLinks;
    }

    public void setUserFilePermissionLinks(Set<UserFilePermissionLink> userFilePermissionLinks) {
        this.userFilePermissionLinks = userFilePermissionLinks;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public FileEnum getType() {
        return type;
    }

    public void setType(FileEnum type) {
        this.type = type;
    }

    public Integer getRevisions() {
        return revisions;
    }

    public void setRevisions(Integer revisions) {
        this.revisions = revisions;
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
