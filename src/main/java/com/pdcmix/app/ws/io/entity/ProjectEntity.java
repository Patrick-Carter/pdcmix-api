package com.pdcmix.app.ws.io.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;

@Entity(name = "project")
@Table(name = "projects")
public class ProjectEntity extends BaseEntity {
    
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

    public Set<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(Set<FileEntity> files) {
        this.files = files;
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

    public Set<DiscussionEntity> getDiscussions() {
        return discussions;
    }

    public void setDiscussions(Set<DiscussionEntity> discussions) {
        this.discussions = discussions;
    }

    public void initEntity(UUID userId) {
        this.setBaseFields(userId);
        this.setStatus(true);
        this.setRevisions(0);
    }
}
