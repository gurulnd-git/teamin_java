package com.equifax.teamin.dto;


import java.util.Date;

public class SourcingDTO {

    private int sourceId;
    private String candidateName;
    private int yearofExperience ;
    private Date planned_start_date ;
    private Date actual_start_date ;
    private String status;
    private ProjectDTO projectDTO;
    private RoleDTO rolesDTO;


    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public RoleDTO getRolesDTO() {
        return rolesDTO;
    }

    public void setRolesDTO(RoleDTO rolesDTO) {
        this.rolesDTO = rolesDTO;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getYearofExperience() {
        return yearofExperience;
    }

    public void setYearofExperience(int yearofExperience) {
        this.yearofExperience = yearofExperience;
    }

    public Date getPlanned_start_date() {
        return planned_start_date;
    }

    public void setPlanned_start_date(Date planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    public Date getActual_start_date() {
        return actual_start_date;
    }

    public void setActual_start_date(Date actual_start_date) {
        this.actual_start_date = actual_start_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}