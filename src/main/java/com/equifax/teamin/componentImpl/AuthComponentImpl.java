package com.equifax.teamin.componentImpl;

import com.equifax.teamin.component.AuthComponent;
import com.equifax.teamin.dao.AuthDAO;
import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.dto.SourcingResponse;
import com.equifax.teamin.dto.UserDTO;
import com.equifax.teamin.entity.User;
import com.equifax.teamin.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthComponentImpl implements AuthComponent {

    @Autowired
    AuthDAO authDAO;

    public SourcingResponse authenticateUser(SourcingRequest sourcingRequest) {
        User user = new User();
        UserDTO userDTO = new UserDTO();
        SourcingResponse sourcingResponse = new SourcingResponse();
        user.setUserName(sourcingRequest.getUsername());
        user.setPassword(sourcingRequest.getPass());
        user = authDAO.login(user);
        if (user != null) {
            userDTO.setUserRole(user.getRole());
            userDTO.setUsername(user.getUserName());
            userDTO.setUserId(Integer.toString(user.getUserId()));
            sourcingResponse.setUserDTO(userDTO);
            sourcingResponse.setAuthMessage("Logged In");
        }
       return sourcingResponse;
    }

    public SourcingResponse registerUser(SourcingRequest sourcingRequest) {
        return null;
    }
}