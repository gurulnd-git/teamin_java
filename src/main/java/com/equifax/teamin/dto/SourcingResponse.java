package com.equifax.teamin.dto;

import java.util.List;


public class SourcingResponse {

    private List<ProgramDTO> programs;
    private List<ProjectDTO> project;
    private List<RoleDTO> roles;
    private List<SourcingDTO> sourcingDTOS;
    private List<ChartDTO> chartDTOS;

    public List<ChartDTO> getChartDTOS() {
        return chartDTOS;
    }

    public void setChartDTOS(List<ChartDTO> chartDTOS) {
        this.chartDTOS = chartDTOS;
    }

    private String authMessage;
    private UserDTO userDTO;

    public List<SourcingDTO> getSourcingDTOS() {
        return sourcingDTOS;
    }

    public void setSourcingDTOS(List<SourcingDTO> sourcingDTOS) {
        this.sourcingDTOS = sourcingDTOS;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    private List<UserDTO> userDTOs;



    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getAuthMessage() {
        return authMessage;
    }

    public void setAuthMessage(String authMessage) {
        this.authMessage = authMessage;
    }

    public void setPrograms(List<ProgramDTO> programs) {
        this.programs = programs;
    }

    public void setProject(List<ProjectDTO> project) {
        this.project = project;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public List<ProjectDTO> getProject() {
        return project;
    }

    public List<ProgramDTO> getPrograms() {
        return programs;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }
}