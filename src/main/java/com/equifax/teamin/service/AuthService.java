package com.equifax.teamin.service;


import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.dto.SourcingResponse;
import org.springframework.stereotype.Service;


public interface AuthService {

    SourcingResponse authenticateUser(SourcingRequest sourcingRequest);
    SourcingResponse registerUser(SourcingRequest sourcingRequest);

}