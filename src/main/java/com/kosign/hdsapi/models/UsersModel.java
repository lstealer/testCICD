package com.kosign.hdsapi.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsersModel implements UserDetails {

    private int id;
    private int userId;
    private String username;
    private String password;
    private String department;
    private String email;
    private List<com.kosign.hdsapi.models.RolesModel> roles;

//    Constructor
    public UsersModel() {
    }

    public UsersModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UsersModel(String username, String password, String department, String email) {
        this.username = username;
        this.password = password;
        this.department = department;
        this.email = email;
    }



    public UsersModel(int id, int userId, String username, String password, String department, String email) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.department = department;
        this.email = email;
    }
    //    Setter And Getter

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RolesModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesModel> roles) {
        this.roles = roles;
    }

    //    implemented method
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
