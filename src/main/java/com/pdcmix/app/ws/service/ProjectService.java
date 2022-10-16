package com.pdcmix.app.ws.service;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdcmix.app.ws.io.entity.ProjectEntity;
import com.pdcmix.app.ws.repo.ProjectRepo;
import com.pdcmix.app.ws.security.JwtTokenUtil;
import com.pdcmix.app.ws.security.PermissionsContainer;
import com.pdcmix.app.ws.shared.dto.ProjectDto;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    PermissionsContainer permissionsContainer;

    public ProjectDto createProject(ProjectDto projectDto, String token) {
        UUID createdByUuid = jwtTokenUtil.getIdAsUuidFromToken(token);

        ProjectEntity projectEntity = new ProjectEntity();
        BeanUtils.copyProperties(projectDto, projectEntity);

        projectEntity.initEntity(createdByUuid);

        ProjectEntity savedProject = projectRepo.save(projectEntity);
        ProjectDto returnValue = this.createDtoObject(savedProject);

        return returnValue;
    }

    public ProjectDto getProject(UUID id) {
        Optional<ProjectEntity> foundProject = projectRepo.findById(id);

        if (!foundProject.isPresent()) {
            throw new EntityNotFoundException();
        }

        ProjectEntity projectEntity = foundProject.get();

        ProjectDto returnValue = this.createDtoObject(projectEntity);

        return returnValue;
    }

    public void deleteProject(UUID id) {
        Optional<ProjectEntity> foundProject = projectRepo.findById(id);

        if (!foundProject.isPresent()) {
            throw new EntityNotFoundException();
        }

        projectRepo.deleteById(id);
    }

    private ProjectDto createDtoObject(ProjectEntity projectEntity) {
        ProjectDto returnValue = new ProjectDto();

        BeanUtils.copyProperties(projectEntity, returnValue);

        return returnValue;
    }
}
