package com.equifax.teamin.serviceImpl;

import com.equifax.teamin.component.AuthComponent;
import com.equifax.teamin.component.SourcingComponent;
import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.dto.SourcingResponse;
import com.equifax.teamin.service.AuthService;
import com.equifax.teamin.service.SourcingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class SourcingServiceImpl implements SourcingService {

    @Autowired
    SourcingComponent sourcingComponent;

    public SourcingResponse getAllusers(SourcingRequest sourcingRequest){
          return sourcingComponent.getAllUsers(sourcingRequest);
    }

    public SourcingResponse getPrograms(SourcingRequest sourcingRequest){
        return sourcingComponent.getPrograms(sourcingRequest);
    }

    public SourcingResponse getProject(SourcingRequest sourcingRequest){
        return sourcingComponent.getProject(sourcingRequest);
    }

    public SourcingResponse createSource(SourcingRequest sourcingRequest){
        return sourcingComponent.createSource(sourcingRequest);
    }

    public SourcingResponse getRoles(SourcingRequest sourcingRequest){
        return sourcingComponent.getRoles(sourcingRequest);

    }

    public SourcingResponse getSources(SourcingRequest sourcingRequest){
        return sourcingComponent.getSources(sourcingRequest);

    }
    public SourcingResponse addProgram(SourcingRequest sourcingRequest){
        return sourcingComponent.addProgram(sourcingRequest);

    }

    public SourcingResponse addProject(SourcingRequest sourcingRequest){
        return sourcingComponent.addProject(sourcingRequest);
    }
    public SourcingResponse addRole(SourcingRequest sourcingRequest){
        return sourcingComponent.addRole(sourcingRequest);
    }


}