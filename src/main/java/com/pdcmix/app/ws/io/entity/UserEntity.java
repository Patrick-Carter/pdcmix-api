package com.pdcmix.app.ws.io.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.links.UserDiscussionNotificationLink;
import com.pdcmix.app.ws.io.links.UserDiscussionPermissionLink;
import com.pdcmix.app.ws.io.links.UserFileNotificationLink;
import com.pdcmix.app.ws.io.links.UserFilePermissionLink;
import com.pdcmix.app.ws.io.links.UserProjectNotificationLink;
import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;

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

    @Column(nullable = true)
    private String emailVerificationToken;

    @Column(nullable = false)
    private Boolean emailVerificationStatus = false;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL")
    private ZonedDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL")
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private Set<ProjectEntity> projects;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private Set<CommentEntity> comments;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private Set<FileEntity> files;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserProjectPermissionLink> userProjectPermissionLinks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserFilePermissionLink> userFilePermissionLinks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserDiscussionPermissionLink> userDiscussionPermissionLinks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserProjectNotificationLink> userProjectNotificationLinks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserFileNotificationLink> userFileNotificationLinks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserDiscussionNotificationLink> userDiscussionNotificationLinks;
    
    public Set<UserProjectNotificationLink> getUserProjectNotificationLinks() {
        return userProjectNotificationLinks;
    }

    public void setUserProjectNotificationLinks(Set<UserProjectNotificationLink> userProjectNotificationLinks) {
        this.userProjectNotificationLinks = userProjectNotificationLinks;
    }

    public Set<UserFileNotificationLink> getUserFileNotificationLinks() {
        return userFileNotificationLinks;
    }

    public void setUserFileNotificationLinks(Set<UserFileNotificationLink> userFileNotificationLinks) {
        this.userFileNotificationLinks = userFileNotificationLinks;
    }

    public Set<UserDiscussionNotificationLink> getUserDiscussionNotificationLinks() {
        return userDiscussionNotificationLinks;
    }

    public void setUserDiscussionNotificationLinks(Set<UserDiscussionNotificationLink> userDiscussionNotificationLinks) {
        this.userDiscussionNotificationLinks = userDiscussionNotificationLinks;
    }

    public Set<UserDiscussionPermissionLink> getUserDiscussionPermissionLinks() {
        return userDiscussionPermissionLinks;
    }

    public void setUserDiscussionPermissionLinks(Set<UserDiscussionPermissionLink> userDiscussionPermissionLinks) {
        this.userDiscussionPermissionLinks = userDiscussionPermissionLinks;
    }

    public Set<UserProjectPermissionLink> getUserProjectPermissionLinks() {
        return userProjectPermissionLinks;
    }

    public void setUserProjectPermissionLinks(Set<UserProjectPermissionLink> userProjectPermissionLinks) {
        this.userProjectPermissionLinks = userProjectPermissionLinks;
    }

    public Set<UserFilePermissionLink> getUserFilePermissionLinks() {
        return userFilePermissionLinks;
    }

    public void setUserFilePermissionLinks(Set<UserFilePermissionLink> userFilePermissionLinks) {
        this.userFilePermissionLinks = userFilePermissionLinks;
    }

    public Set<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Set<ProjectEntity> projects) {
        this.projects = projects;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public Set<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(Set<FileEntity> files) {
        this.files = files;
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
