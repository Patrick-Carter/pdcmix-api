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

import com.pdcmix.app.ws.io.entity.BaseEntity;
import com.pdcmix.app.ws.io.entity.PermissionEntity;
import com.pdcmix.app.ws.io.entity.ProjectEntity;
import com.pdcmix.app.ws.io.entity.UserEntity;

@Entity(name = "userProjectPermission")
@Table(name = "user_project_permissions")
public class UserProjectPermissionLink extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "permission_id")
    private PermissionEntity permission;

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

    public PermissionEntity getPermission() {
        return permission;
    }

    public void setPermission(PermissionEntity permission) {
        this.permission = permission;
    }
}

// https://stackoverflow.com/questions/42488559/manytomany-relationship-between-three-tables

// class User {
// @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,
// CascadeType.MERGE})
// private Set<UserDepartmentRoleLink> userDepartmentRoleLinks;
// }

// class Department{
// @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST,
// CascadeType.MERGE})
// private Set<UserDepartmentRoleLink> userDepartmentRoleLinks;
// }

// class Role{
// @OneToMany(mappedBy = "role", cascade = {CascadeType.PERSIST,
// CascadeType.MERGE})
// private Set<UserDepartmentRoleLink> userDepartmentRoleLinks;
// }

// class UserDepartmentRoleLink {

// @Id
// @GeneratedValue
// private Long id;

// @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
// @JoinColumn(name = "user_id")
// private User user;

// @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
// @JoinColumn(name = "department_id")
// private Department department;

// @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
// @JoinColumn(name = "role_id")
// private Role role;

// }
