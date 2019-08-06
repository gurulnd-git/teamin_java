package com.equifax.teamin.controller;

import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.dto.SourcingResponse;
import com.equifax.teamin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    AuthService authService;

    @CrossOrigin("")
    @PostMapping("login")
    public ResponseEntity<SourcingResponse> login(@RequestBody SourcingRequest sourcingRequest) {

        return new ResponseEntity<SourcingResponse>(authService.authenticateUser(sourcingRequest), HttpStatus.OK);
    }
   @RequestMapping("signup")
    public String signup() {

        return "";
    }

}




