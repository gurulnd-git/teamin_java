package com.equifax.teamin.dto;


import java.util.List;

public class ProgramDTO {


    private String programId;
    private String programName;
    private List<ProjectDTO> projectDTOS;

    public List<ProjectDTO> getProjectDTOS() {
        return projectDTOS;
    }

    public void setProjectDTOS(List<ProjectDTO> projectDTOS) {
        this.projectDTOS = projectDTOS;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramId() {
        return programId;
    }

    public String getProgramName() {
        return programName;
    }


  }