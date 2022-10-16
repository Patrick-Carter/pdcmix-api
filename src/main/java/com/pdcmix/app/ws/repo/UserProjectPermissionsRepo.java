package com.pdcmix.app.ws.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;

public interface UserProjectPermissionsRepo extends CrudRepository<UserProjectPermissionLink, UUID> {

}
