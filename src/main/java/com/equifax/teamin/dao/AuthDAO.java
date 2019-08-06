package com.equifax.teamin.dao;

import com.equifax.teamin.Repo.UserRepo;
import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.dto.SourcingResponse;
import com.equifax.teamin.entity.User;
import com.equifax.teamin.service.AuthService;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private UserRepo userRepo;

       public List<User> getAllUsers() {
            System.out.println("enter in the list");
            String hql = "FROM User as user ";

            return (List<User>) entityManager.createQuery(hql).getResultList();
        }

    public User login(User user) {
        String hql = "FROM User as user where user_name = :username and password = :pass";

        List<User> users = (List<User>)  entityManager.createQuery(hql, User.class)
                .setParameter( "username", user.getUserName() )
                .setParameter( "pass", user.getPassword() )
                .getResultList();
        User loggedInUser = null;
        if (!CollectionUtils.isEmpty(users)) {
            loggedInUser = new User();
            loggedInUser = users.get(0);
        }

        return loggedInUser;
    }

}