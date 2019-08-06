package com.equifax.teamin.dto;


public class UserDTO {

    private String username;
    private String userRole;
    private String userId;

    public String getUsername() {
        return username;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}