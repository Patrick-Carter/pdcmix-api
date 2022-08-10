package com.pdcmix.app.ws.io.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.enums.PermissionEnum;

@Entity(name = "permission")
@Table(name = "permissions")
public class PermissionEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PermissionEnum type;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PermissionEnum getType() {
        return type;
    }

    public void setType(PermissionEnum type) {
        this.type = type;
    }
}
