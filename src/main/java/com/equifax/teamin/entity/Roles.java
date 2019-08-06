package com.equifax.teamin.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="role")

public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="role_id")
    private int roleId;
    @Column(name="role_name")
    private String roleName;

    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }



}
