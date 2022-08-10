package com.pdcmix.app.ws.io.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 13457346345686L;

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable = false)
    private Boolean emailVerificationStatus = false;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime updatedAt;

    @Column()
    private List<ProjectEntity> projects;

    @Column()
    private List<CommentEntity> comments;

    @Column()
    private List<FileEntity> projectFiles;

    @Column()
    private List<PermissionEntity> projectPermissions;

    @Column()
    private List<PermissionEntity> filePermissions;

    @Column
    private List<NotificationEntity> projectNotifications;

    @Column
    private List<NotificationEntity> fileNotifications;

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<FileEntity> getProjectFiles() {
        return projectFiles;
    }

    public void setProjectFiles(List<FileEntity> projectFiles) {
        this.projectFiles = projectFiles;
    }

    public List<PermissionEntity> getProjectPermissions() {
        return projectPermissions;
    }

    public void setProjectPermissions(List<PermissionEntity> projectPermissions) {
        this.projectPermissions = projectPermissions;
    }

    public List<PermissionEntity> getFilePermissions() {
        return filePermissions;
    }

    public void setFilePermissions(List<PermissionEntity> filePermissions) {
        this.filePermissions = filePermissions;
    }

    public List<NotificationEntity> getProjectNotifications() {
        return projectNotifications;
    }

    public void setProjectNotifications(List<NotificationEntity> projectNotifications) {
        this.projectNotifications = projectNotifications;
    }

    public List<NotificationEntity> getFileNotifications() {
        return fileNotifications;
    }

    public void setFileNotifications(List<NotificationEntity> fileNotifications) {
        this.fileNotifications = fileNotifications;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
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
}
