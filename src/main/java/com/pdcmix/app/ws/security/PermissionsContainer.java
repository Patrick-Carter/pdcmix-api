package com.pdcmix.app.ws.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;

@Component
@RequestScope
public class PermissionsContainer {
    private UserProjectPermissionLink[] userProjectPermissions;

    public UserProjectPermissionLink[] getUserProjectPermissions() {
        return userProjectPermissions;
    }

    public void setUserProjectPermissions(UserProjectPermissionLink[] userProjectPermissions) {
        this.userProjectPermissions = userProjectPermissions;
    }

}
