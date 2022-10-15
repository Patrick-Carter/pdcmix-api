package com.pdcmix.app.ws.io.entity;

import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "created_by", nullable = true)
    private UserEntity createdBy;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "updated_by", nullable = true)
    private UserEntity updatedBy;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT NOW()")
    private ZonedDateTime updatedAt;

    public void setBaseFields(UUID createdByUuid) {
        UserEntity user = new UserEntity();
        user.setId(createdByUuid);
        this.setCreatedAt(ZonedDateTime.now());
        this.setUpdatedAt(ZonedDateTime.now());
        this.setCreatedBy(user);
        this.setUpdatedBy(user);
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserEntity getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserEntity updatedBy) {
        this.updatedBy = updatedBy;
    }
}
