package com.pdcmix.app.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdcmix.app.ws.repo.UserProjectPermissionsRepo;

@Service
public class PermissionsService {

    @Autowired
    UserProjectPermissionsRepo userProjectPermissionsRepo;
    
}
