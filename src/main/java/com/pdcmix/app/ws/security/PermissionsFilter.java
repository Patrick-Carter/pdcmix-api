package com.pdcmix.app.ws.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pdcmix.app.ws.io.links.UserProjectPermissionLink;
import com.pdcmix.app.ws.service.UserProjectPermissionsService;


@Component
public class PermissionsFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserProjectPermissionsService userProjectPermissionsService;

    @Autowired
    private PermissionsContainer permissionsContainer;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");
        final String methodType = request.getMethod();

       

        String pathInfo = request.getRequestURI();
        String[] parts = pathInfo.split("/");


        String entity = parts[1];

        if (entity.equals("projects") && methodType.equals("GET")) {
            String entityId = parts[2];
            UUID userId = jwtTokenUtil.getIdAsUuidFromToken(requestTokenHeader);
            UserProjectPermissionLink[] permissions = userProjectPermissionsService.getUserProjectPermissions(userId, UUID.fromString(entityId));
            boolean canAccess = false;
            for (UserProjectPermissionLink p : permissions) {
                if (p.getPermission().getPermission().equals("get")) {
                    canAccess = true;
                    break;
                }
            }

            if (!canAccess) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "You do not have permissions to view this project");
            }
            permissionsContainer.setUserProjectPermissions(permissions);
        }
        

        filterChain.doFilter(request, response);
    }

}
