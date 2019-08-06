package com.equifax.teamin.component;

import com.equifax.teamin.dao.AuthDAO;
import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.dto.SourcingResponse;
import com.equifax.teamin.dto.UserDTO;
import com.equifax.teamin.entity.User;
import com.equifax.teamin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public interface AuthComponent {

    SourcingResponse authenticateUser(SourcingRequest sourcingRequest);
    SourcingResponse registerUser(SourcingRequest sourcingRequest);

}