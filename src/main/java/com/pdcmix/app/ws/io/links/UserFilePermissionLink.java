package com.pdcmix.app.ws.io.links;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.entity.FileEntity;
import com.pdcmix.app.ws.io.entity.PermissionEntity;
import com.pdcmix.app.ws.io.entity.UserEntity;

@Entity(name = "userFilePermission")
@Table(name = "user_file_permissions")
public class UserFilePermissionLink {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private FileEntity file;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id")
    private PermissionEntity permission;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", nullable = true)
    private UserEntity createdBy;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public FileEntity getFile() {
        return file;
    }

    public void setFile(FileEntity file) {
        this.file = file;
    }

    public PermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(PermissionEntity permission) {
        this.permission = permission;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
