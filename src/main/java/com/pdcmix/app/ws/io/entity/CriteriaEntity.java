package com.pdcmix.app.ws.io.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pdcmix.app.ws.io.enums.CriteriaEnum;

@Entity(name = "criteria")
@Table(name = "criteria")
public class CriteriaEntity {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CriteriaEnum type;
}
