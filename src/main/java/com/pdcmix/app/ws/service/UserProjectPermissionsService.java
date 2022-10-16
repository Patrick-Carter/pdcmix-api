package com.pdcmix.app.ws.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdcmix.app.ws.io.entity.PermissionEntity;
import com.pdcmix.app.ws.io.entity.ProjectEntity;
import com.pdcmix.app.ws.io.entity.UserEntity;
import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;
import com.pdcmix.app.ws.repo.UserProjectPermissionsRepo;
import com.pdcmix.app.ws.security.JwtTokenUtil;

@Service
public class UserProjectPermissionsService {

    @Autowired
    UserProjectPermissionsRepo userProjectPermissionsRepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserProjectPermissionLink[] getUserProjectPermissions(UUID userId, UUID projectId) {
        UserProjectPermissionLink[] permissions = userProjectPermissionsRepo.findAllByUserIdAndProjectId(userId, projectId);


        return permissions;
    }

    public void setInitialPermissionsOnProject(String token, UUID projectId) {
        UUID userId = jwtTokenUtil.getIdAsUuidFromToken(token);
        UserProjectPermissionLink getPermission = new UserProjectPermissionLink();
        
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setId(UUID.fromString("1757f1d0-42c8-46c1-80e9-115e6ac19c0f"));
        getPermission.setPermission(permissionEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        getPermission.setUser(userEntity);

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(projectId);
        getPermission.setProject(projectEntity);

        getPermission.setBaseFields(userId);

        userProjectPermissionsRepo.save(getPermission);
    }
    
}
