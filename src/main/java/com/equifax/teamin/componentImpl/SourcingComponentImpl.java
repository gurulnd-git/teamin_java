package com.equifax.teamin.componentImpl;

import com.equifax.teamin.component.SourcingComponent;
import com.equifax.teamin.dao.SourcingDAO;
import com.equifax.teamin.dto.*;
import com.equifax.teamin.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SourcingComponentImpl implements SourcingComponent {

    @Autowired
    SourcingDAO sourcingDAO;

    public SourcingResponse getAllUsers(SourcingRequest sourcingRequest) {

        SourcingResponse sourcingResponse = new SourcingResponse();
        List<User> users = sourcingDAO.getAllUsers();
        List<UserDTO> userDTOs = new ArrayList<>();
        if (!CollectionUtils.isEmpty(users)) {

            for (User user : users) {
                UserDTO userDTO = new UserDTO();
                userDTO.setUserId((Integer.toString(user.getUserId())));
                userDTO.setUsername(user.getUserName());
                userDTO.setUserRole(user.getRole());
                userDTOs.add(userDTO);
            }
        }

        sourcingResponse.setUserDTOs(userDTOs);
        return sourcingResponse;
    }

        public SourcingResponse getPrograms(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        List<Programs> programs = sourcingDAO.getPrograms();
        List<ProgramDTO> programDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(programs)) {
            for (Programs programs1 : programs) {
                ProgramDTO programDTO = new ProgramDTO();
                programDTO.setProgramId(Integer.toString(programs1.getProgramId()));
                programDTO.setProgramName(programs1.getProgramName());
                programDTOS.add(programDTO);
            }
        }
        sourcingResponse.setPrograms(programDTOS);
        return sourcingResponse;

    }

    public SourcingResponse getProject(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        List<Projects> projects = sourcingDAO.getProjects(sourcingRequest);
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(projects)) {
            for (Projects projects1 : projects) {
                ProjectDTO projectDTO = new ProjectDTO();
                projectDTO.setProjectId(Integer.toString(projects1.getProjectId()));
                projectDTO.setProjectName(projects1.getProjectName());
                projectDTOS.add(projectDTO);
            }
        }
        sourcingResponse.setProject(projectDTOS);
        return sourcingResponse;

    }

    public SourcingResponse getRole(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        List<Roles> roles = sourcingDAO.getRoles(sourcingRequest);
        List<RoleDTO> roleDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roles)) {
            for (Roles roles1 : roles) {
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(Integer.toString(roles1.getRoleId()));
                roleDTO.setRoleName(roles1.getRoleName());
                roleDTOS.add(roleDTO);
            }
        }
        sourcingResponse.setRoles(roleDTOS);
        return sourcingResponse;

    }

    public SourcingResponse createSource(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        SourcingDTO sourcingDTO = sourcingRequest.getSourcingDTO();
        if (sourcingDTO != null) {

            Source source = new Source();
            Programs program = new Programs();
            Projects project = new Projects();
            Roles role = new Roles();
            source.setActual_start_date(sourcingDTO.getActual_start_date());
            source.setCandidateName(sourcingDTO.getCandidateName());
            source.setPlanned_start_date(sourcingDTO.getPlanned_start_date());
            if (sourcingDTO.getRolesDTO() != null) {
                role.setRoleId(Integer.parseInt(sourcingDTO.getRolesDTO().getRoleId()));
                source.setRole(role);
            }
            //program.setProgramName(sourcingDTO.getProgramDTO().getProgramName());
            if (sourcingDTO.getProjectDTO() != null) {
                project.setProjectId(Integer.parseInt(sourcingDTO.getProjectDTO().getProjectId()));
            }
            //   source.setProgram(program);
            source.setProject(project);

            source.setSourceId(sourcingDTO.getSourceId());
            source.setStatus(sourcingDTO.getStatus());
            source.setYearofExperience(sourcingDTO.getYearofExperience());
            sourcingDAO.saveSourcing(source);
        }
        return sourcingResponse;
    }

    public SourcingResponse getRoles(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        List<Roles> roles = sourcingDAO.getRoles(sourcingRequest);
        List<RoleDTO> roleDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(roles)) {
            for (Roles roles1 : roles) {
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(Integer.toString(roles1.getRoleId()));
                roleDTO.setRoleName(roles1.getRoleName());
                roleDTOS.add(roleDTO);
            }
        }
        sourcingResponse.setRoles(roleDTOS);
        return sourcingResponse;

    }


    public SourcingResponse getSources(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        List<Source> sources = sourcingDAO.getSources(sourcingRequest);
        List<SourcingDTO> sourcingDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(sources)) {
            for (Source source : sources) {
                SourcingDTO sourcingDTO = new SourcingDTO();
                ProjectDTO projectDTO = new ProjectDTO();
                RoleDTO roleDTO = new RoleDTO();

                //sourcingDTO.setActual_start_date(source.getActual_start_date());
                sourcingDTO.setCandidateName(source.getCandidateName());
                // sourcingDTO.setPlanned_start_date(source.getPlanned_start_date());
                sourcingDTO.setSourceId(source.getSourceId());
                sourcingDTO.setStatus(source.getStatus());
                sourcingDTO.setYearofExperience(source.getYearofExperience());

                /*if (source.getProgram() != null) {
                    programDTO.setProgramName(source.getProgram().getProgramName());
                }*/

                if (source.getProject() != null) {
                    if (source.getProject().getProjectId() != 0) {
                        projectDTO.setProjectId(Integer.toString(source.getProject().getProjectId()));
                    }
                    projectDTO.setProjectName(source.getProject().getProjectName());
                }

                if (source.getRole() != null) {
                    if (source.getRole().getRoleId() != 0) {
                        roleDTO.setRoleId(Integer.toString(source.getRole().getRoleId()));
                    }
                    roleDTO.setRoleName(source.getRole().getRoleName());
                }


                //sourcingDTO.setProgramDTO(programDTO);
                sourcingDTO.setProjectDTO(projectDTO);
                sourcingDTO.setRolesDTO(roleDTO);
                sourcingDTOS.add(sourcingDTO);
            }
        }
        sourcingResponse.setSourcingDTOS(sourcingDTOS);
        return sourcingResponse;

    }


    public SourcingResponse addProgram(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        ProgramDTO programDTO = sourcingRequest.getProgramDTO();
        if (programDTO != null) {
            Programs programs = new Programs();

            programs.setProgramName(programDTO.getProgramName());
            sourcingDAO.addProgram(programs);

        }
        return sourcingResponse;
    }

    public SourcingResponse addProject(SourcingRequest sourcingRequest) {
        SourcingResponse sourcingResponse = new SourcingResponse();
        ProjectDTO projectDTO = sourcingRequest.getProjectDTO();
        Programs programs=new Programs();
        if (projectDTO != null) {
            Projects projects = new Projects();
            projects.setProjectName(projectDTO.getProjectName());
            if(projectDTO.getProgramDTO()!=null){
                programs.setProgramId(Integer.parseInt(projectDTO.getProgramDTO().getProgramId()));
            }
            projects.setPrograms(programs);
            sourcingDAO.addProject(projects);
        }
        return sourcingResponse;
    }

    public SourcingResponse addRole(SourcingRequest sourcingRequest){
        SourcingResponse sourcingResponse=new SourcingResponse();
        RoleDTO roleDTO=sourcingRequest.getRoleDTO();
       if(roleDTO!=null) {
           Roles roles = new Roles();
           roles.setRoleName(roleDTO.getRoleName());
           sourcingDAO.addRole(roles);
       }
       return  sourcingResponse;

       }

}
