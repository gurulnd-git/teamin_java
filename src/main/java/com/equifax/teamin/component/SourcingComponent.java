package com.equifax.teamin.component;

import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.dto.SourcingResponse;
import org.springframework.stereotype.Component;


public interface SourcingComponent {
    SourcingResponse getAllUsers(SourcingRequest sourcingRequest);
    SourcingResponse getPrograms(SourcingRequest sourcingRequest);
    SourcingResponse getProject(SourcingRequest sourcingRequest);
    SourcingResponse createSource(SourcingRequest sourcingRequest);
    SourcingResponse getRoles(SourcingRequest sourcingRequest);
    SourcingResponse getSources(SourcingRequest sourcingRequest);
    SourcingResponse addProgram(SourcingRequest sourcingRequest);
    SourcingResponse addProject(SourcingRequest sourcingRequest);
    SourcingResponse addRole(SourcingRequest sourcingRequest);

}