package com.pdcmix.app.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdcmix.app.ws.service.ProjectService;
import com.pdcmix.app.ws.shared.dto.ProjectDto;
import com.pdcmix.app.ws.ui.model.request.ProjectNewReqModel;
import com.pdcmix.app.ws.ui.model.response.ProjectCreateResModel;

@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/new")
    public ProjectCreateResModel createProject(@RequestBody ProjectNewReqModel newProjectReq,
            @RequestHeader(value = "Authorization") String authorization) {

        ProjectDto projectDto = new ProjectDto();
        BeanUtils.copyProperties(newProjectReq, projectDto);

        ProjectCreateResModel response = new ProjectCreateResModel();
        ProjectDto savedProject = projectService.createProject(projectDto, authorization);

        BeanUtils.copyProperties(savedProject, response);
        return response;

    }
}
