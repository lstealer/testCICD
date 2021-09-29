package com.kosign.hdsapi.models;

import org.springframework.security.core.GrantedAuthority;

public class RolesModel implements GrantedAuthority {

    private int role_id;
    private String role;



    //Constructor
    public RolesModel() {
    }

    public RolesModel(int role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }

    //setter
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //Getter
    public int getRole_id() {
        return role_id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "RolesModel{" +
                "role_id=" + role_id +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + role;
    }
}
