package com.pdcmix.app.ws.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;

@Repository
public interface UserProjectPermissionsRepo extends CrudRepository<UserProjectPermissionLink, UUID> {
    UserProjectPermissionLink[] findAllByUserIdAndProjectId(UUID userId, UUID projectId);
}
