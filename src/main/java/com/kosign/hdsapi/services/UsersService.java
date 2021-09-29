package com.kosign.hdsapi.services;

import com.kosign.hdsapi.models.UsersModel;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service

public interface UsersService extends UserDetailsService {
    UsersModel insertNewUser(UsersModel usersModel);
    UsersModel userLogin(UsersModel usersModel);
    Boolean usernameCheck(String name);
}
