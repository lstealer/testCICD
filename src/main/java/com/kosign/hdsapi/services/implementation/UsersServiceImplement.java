package com.kosign.hdsapi.services.implementation;

import com.kosign.hdsapi.models.UsersModel;
import com.kosign.hdsapi.repositories.UsersRepository;
import com.kosign.hdsapi.services.UsersService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("userServices")
public class UsersServiceImplement implements UsersService {

    private UsersRepository userRepository;

    @Autowired
    @Qualifier("userRepository")
    public void setUserRepository(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUserName");
        System.out.println("User Detail = " + userRepository.selectUserByUsername(username));
        return userRepository.selectUserByUsername(username);
    }
    @Override
    public Boolean usernameCheck(String name) {
        String checkName= userRepository.usernameCheck(name);
        if(checkName==null)
        return true;
        else return false;
    }
    @Override
    public UsersModel insertNewUser(UsersModel usersModel) {
        UsersModel userInserted=null;
        System.out.println("Userservices");
        try{
            if (userRepository.insertNewUser(usersModel))
                userInserted = userRepository.selectUserByUsername(usersModel.getUsername());
        }catch (TooManyResultsException exception){
            userInserted=null;
        }
        return userInserted;
    }
    @Override
    public UsersModel userLogin(UsersModel usersModel){
        System.out.println(usersModel.getPassword());
        UsersModel userSelected= userRepository.userLogin(usersModel.getUsername(),usersModel.getPassword());
        return userSelected;
    }
}
