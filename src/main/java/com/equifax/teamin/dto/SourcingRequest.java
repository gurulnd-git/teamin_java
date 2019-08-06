package com.equifax.teamin.dto;


public class SourcingRequest {

    private String username;
    private String pass;
    private SourcingDTO sourcingDTO;



    private ProgramDTO programDTO;
    private ProjectDTO projectDTO;
    private RoleDTO roleDTO;

    public ProgramDTO getProgramDTO() {
        return programDTO;
    }

    public void setProgramDTO(ProgramDTO programDTO) {
        this.programDTO = programDTO;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }
    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public SourcingDTO getSourcingDTO() {
        return sourcingDTO;
    }

    public void setSourcingDTO(SourcingDTO sourcingDTO) {
        this.sourcingDTO = sourcingDTO;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}