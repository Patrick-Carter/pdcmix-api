package com.pdcmix.app.ws.ui.controller;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdcmix.app.ws.service.ProjectService;
import com.pdcmix.app.ws.shared.dto.ProjectDto;
import com.pdcmix.app.ws.ui.model.request.ProjectNewReqModel;
import com.pdcmix.app.ws.ui.model.response.ProjectBaseResModel;

@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/new")
    public ProjectBaseResModel create(@RequestBody ProjectNewReqModel newProjectReq,
            @RequestHeader(value = "Authorization") String authorization) {

        ProjectDto projectDto = new ProjectDto();
        BeanUtils.copyProperties(newProjectReq, projectDto);

        ProjectBaseResModel response = new ProjectBaseResModel();
        ProjectDto savedProject = projectService.createProject(projectDto, authorization);

        BeanUtils.copyProperties(savedProject, response);
        return response;
    }

    @GetMapping("/{id}")
    public ProjectBaseResModel get(@PathVariable("id") UUID id, @RequestHeader(value = "Authorization") String authorization) {
        ProjectBaseResModel response = new ProjectBaseResModel();
        ProjectDto project = projectService.getProject(id);
        BeanUtils.copyProperties(project, response);
        return response;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id, @RequestHeader(value = "Authorization") String authorization) {
        projectService.deleteProject(id);
        return "Project was deleted";
    }
}
