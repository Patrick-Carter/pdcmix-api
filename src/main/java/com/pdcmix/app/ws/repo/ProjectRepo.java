package com.pdcmix.app.ws.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pdcmix.app.ws.io.entity.ProjectEntity;

@Repository
public interface ProjectRepo extends CrudRepository<ProjectEntity, UUID>{
    
}
