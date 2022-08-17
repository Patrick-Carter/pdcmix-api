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

import com.pdcmix.app.ws.io.entity.NotificationEntity;
import com.pdcmix.app.ws.io.entity.ProjectEntity;
import com.pdcmix.app.ws.io.entity.UserEntity;

@Entity(name = "userProjectNotification")
@Table(name = "user_project_notifications")
public class UserProjectNotificationLink {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id")
    private NotificationEntity notification;

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

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public NotificationEntity getNotification() {
        return notification;
    }

    public void setNotification(NotificationEntity notification) {
        this.notification = notification;
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