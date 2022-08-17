package com.pdcmix.app.ws.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdcmix.app.ws.io.entity.ProjectEntity;
import com.pdcmix.app.ws.io.entity.UserEntity;
import com.pdcmix.app.ws.repo.ProjectRepo;
import com.pdcmix.app.ws.repo.UserRepo;
import com.pdcmix.app.ws.security.JwtTokenUtil;
import com.pdcmix.app.ws.shared.dto.ProjectDto;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public ProjectDto createProject(ProjectDto projectDto, String token) {

        String pulledUuid = jwtTokenUtil.getIdFromToken(token);
        UUID createdByUuid = UUID.fromString(pulledUuid);

        ProjectEntity projectEntity = new ProjectEntity();
        BeanUtils.copyProperties(projectDto, projectEntity);

        UserEntity test = new UserEntity();
        test.setId(createdByUuid);
        projectEntity.setCreatedBy(test);
        projectEntity.setUpdatedBy(test);
        projectEntity.setStatus(true);
        projectEntity.setRevisions(0);
        projectEntity.setCreatedAt(ZonedDateTime.now());

        ProjectEntity savedProject = projectRepo.save(projectEntity);
        ProjectDto returnValue = new ProjectDto();

        BeanUtils.copyProperties(savedProject, returnValue);

        return returnValue;
    }
}
