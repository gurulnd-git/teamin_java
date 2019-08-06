package com.equifax.teamin.controller;

import com.equifax.teamin.dto.*;
import com.equifax.teamin.service.SourcingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("user")
public class SourcingController {

    @Autowired
    SourcingService sourcingService;

    @CrossOrigin()
    @PostMapping("initSourcing")
    public ResponseEntity<SourcingResponse> initSourcing(@RequestBody SourcingRequest sourcingRequest) {

        SourcingResponse sourcingResponse = new SourcingResponse();
        sourcingResponse.setSourcingDTOS(sourcingService.getSources(sourcingRequest).getSourcingDTOS());
        return  new ResponseEntity<SourcingResponse>(sourcingResponse, HttpStatus.OK);
    }

    @CrossOrigin()
    @PostMapping("getAllUsers")
    public ResponseEntity<SourcingResponse> getAllUsers(@RequestBody SourcingRequest sourcingRequest) {

        return  new ResponseEntity<SourcingResponse>(sourcingService.getAllusers(sourcingRequest), HttpStatus.OK);
    }
    @CrossOrigin()
    @PostMapping("getPrograms")
    public ResponseEntity<SourcingResponse> getPrograms(@RequestBody SourcingRequest sourcingRequest) {

        return  new ResponseEntity<SourcingResponse>(sourcingService.getPrograms(sourcingRequest), HttpStatus.OK);
    }

    @CrossOrigin()
    @PostMapping("getProject")
    public ResponseEntity<SourcingResponse> getProject(@RequestBody SourcingRequest sourcingRequest) {

        return  new ResponseEntity<SourcingResponse>(sourcingService.getProject(sourcingRequest), HttpStatus.OK);
    }

    @CrossOrigin()
    @PostMapping("getRole")
    public ResponseEntity<SourcingResponse> getRole(@RequestBody SourcingRequest sourcingRequest) {

        return  new ResponseEntity<SourcingResponse>(sourcingService.getRoles(sourcingRequest), HttpStatus.OK);
    }

    @CrossOrigin()
    @PostMapping("createSource")
    public ResponseEntity<SourcingResponse> createSource(@RequestBody SourcingRequest sourcingRequest ) {
        SourcingResponse sourcingResponse = sourcingService.createSource(sourcingRequest);
        return new ResponseEntity<SourcingResponse>(sourcingResponse, HttpStatus.CREATED);
    }

    @CrossOrigin()
    @PostMapping("loadInitData")
    public ResponseEntity<SourcingResponse> loadInitData(@RequestBody SourcingRequest sourcingRequest) {

        SourcingResponse sourcingResponse = new SourcingResponse();
        sourcingResponse.setPrograms(sourcingService.getPrograms(sourcingRequest).getPrograms());
        sourcingResponse.setProject(sourcingService.getProject(sourcingRequest).getProject());
        sourcingResponse.setRoles(sourcingService.getRoles(sourcingRequest).getRoles());
        return  new ResponseEntity<SourcingResponse>(sourcingResponse, HttpStatus.OK);
    }

    @CrossOrigin()
    @PostMapping("loadChart")
    public ResponseEntity<SourcingResponse> loadChart(@RequestBody SourcingRequest sourcingRequest) {

        SourcingResponse sourcingResponse = new SourcingResponse();
        sourcingResponse.setChartDTOS( createChartData() );
        return  new ResponseEntity<SourcingResponse>(sourcingResponse, HttpStatus.OK);
    }

    private  List<ChartDTO> createChartData() {
        List<ChartDTO> chartDTOS = new ArrayList<>();
        ChartDTO chartDTO = new ChartDTO();
        chartDTO.setLabel("Equifax");
        chartDTO.setExpanded(true);
      //  chartDTO.setImg("/assets/person-icon.jpg");
      //  chartDTO.setDesignation("Account");

        List<ProgramDTO> programDTOS = sourcingService.getPrograms(new SourcingRequest()).getPrograms();
        List<ChartDTO> programChartDTOs = new ArrayList<>();

        for (ProgramDTO programDTO : programDTOS) {
            ChartDTO programChartDTO = new ChartDTO();
            programChartDTO.setLabel(programDTO.getProgramName());
           // programChartDTO.setImg("/assets/person-icon.jpg");
          //  programChartDTO.setDesignation("");
            programChartDTO.setExpanded(true);
            programChartDTO.setChildren(getProjectChartForProgram(programDTO));
            programChartDTOs.add(programChartDTO);
        }
        chartDTO.setChildren(programChartDTOs);
        chartDTOS.add(chartDTO);
        return chartDTOS;
    }


    private List<ChartDTO> getProjectChartForProgram (ProgramDTO programDTO) {
        List<ChartDTO> projectChartDTOs = new ArrayList<>();
        SourcingRequest sourcingRequest = new SourcingRequest();
        sourcingRequest.setProgramDTO(programDTO);
        List<ProjectDTO> projectDTOS = sourcingService.getProject(sourcingRequest).getProject();

        for (ProjectDTO projectDTO : projectDTOS) {
            ChartDTO projectChartDTO = new ChartDTO();
            projectChartDTO.setLabel(projectDTO.getProjectName());
           // projectChartDTO.setImg("/assets/person-icon.jpg");
           // projectChartDTO.set("");
            projectChartDTO.setChildren(getSourceChartForProgram(projectDTO));
            projectChartDTOs.add(projectChartDTO);
        }
        return projectChartDTOs;
    }

    private List<ChartDTO> getSourceChartForProgram (ProjectDTO projectDTO) {
        List<ChartDTO> sourcingChartDTOs = new ArrayList<>();
        SourcingRequest sourcingRequest = new SourcingRequest();
        sourcingRequest.setProjectDTO(projectDTO);
        List<SourcingDTO> sourcingDTOS = sourcingService.getSources(sourcingRequest).getSourcingDTOS();

        for (SourcingDTO sourcingDTO : sourcingDTOS) {
            ChartDTO sourcingChartDTO = new ChartDTO();
            sourcingChartDTO.setLabel(sourcingDTO.getCandidateName());
          //  sourcingChartDTO.setImg("/assets/person-icon.jpg");
          //  sourcingChartDTO.setDesignation(sourcingDTO.getRolesDTO().getRoleName());
            sourcingChartDTO.setChildren(new ArrayList<>());
            sourcingChartDTOs.add(sourcingChartDTO);
        }
        return sourcingChartDTOs;
    }

    @CrossOrigin()
    @PostMapping("addProgram")
    public ResponseEntity<SourcingResponse> addProgram(@RequestBody SourcingRequest sourcingRequest ) {
        SourcingResponse sourcingResponse = sourcingService.addProgram(sourcingRequest);
        return new ResponseEntity<SourcingResponse>(sourcingResponse, HttpStatus.CREATED);
    }


    @CrossOrigin()
    @PostMapping("addProject")
    public ResponseEntity<SourcingResponse> addproject(@RequestBody SourcingRequest sourcingRequest){
        SourcingResponse sourcingResponse=sourcingService.addProject(sourcingRequest);
        return  new ResponseEntity<SourcingResponse>(sourcingResponse,HttpStatus.CREATED);
    }

    @CrossOrigin()
    @PostMapping("addRole")
    public ResponseEntity<SourcingResponse> addRole(@RequestBody SourcingRequest sourcingRequest){
        SourcingResponse sourcingResponse=sourcingService.addRole(sourcingRequest);
        return new ResponseEntity<SourcingResponse>(sourcingResponse,HttpStatus.CREATED);
    }
}




