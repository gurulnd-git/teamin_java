package com.equifax.teamin.dto;


import java.util.List;

public class ProjectDTO {

    private String projectName;
    private String projectId;
    private ProgramDTO programDTO;
    private List<SourcingDTO> sourceDtos;

    public ProgramDTO getProgramDTO() {
        return programDTO;
    }

    public void setProgramDTO(ProgramDTO programDTO) {
        this.programDTO = programDTO;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

  }