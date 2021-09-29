package com.kosign.hdsapi.controllers;

import com.kosign.hdsapi.models.BaseApiResponseModel;
import com.kosign.hdsapi.models.UsersModel;
import com.kosign.hdsapi.services.UsersService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UsersController {

    private UsersService userService;

    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
//    @Qualifier("userServices")
    public void setUsersService(@Qualifier("userServices") UsersService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<BaseApiResponseModel<UsersModel>> insert(
            @RequestBody UsersModel user
    ) {
            System.out.println(user);
            BaseApiResponseModel<UsersModel> response = new BaseApiResponseModel<>();
//            user.setPassword(encoder.encode(user.getPassword()));
        UsersModel userInserted=null;
        if(userService.usernameCheck(user.getUsername())) {
             userInserted = userService.insertNewUser(user);
            response.setStatus(HttpStatus.OK);
            System.out.println("Check Name OK");
        }else {
            response.setStatus(HttpStatus.OK);
            response.setMessage("Your username have been used!");
            response.setTime(new Timestamp(System.currentTimeMillis()));
            return ResponseEntity.ok(response);
        }
            response.setTime(new Timestamp(System.currentTimeMillis()));
        try  {
                if (userInserted != null) {
                    response.setData(userInserted);
                    response.setMessage("You have inserted the user successfully!");
                }else response.setMessage("Your user insert have been failed !");
//            System.out.println(userInserted);

        }catch (TooManyResultsException exception){
            response.setMessage("Your user insert have been failed !");
        }
        catch (DuplicateKeyException exception){
            response.setMessage("Your username have been used!");
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping("/login")
    public ResponseEntity<BaseApiResponseModel<UsersModel>> userLogin(
            @RequestBody UsersModel usersModel
    ){
        BaseApiResponseModel<UsersModel> response = new BaseApiResponseModel<>();
        UsersModel data =userService.userLogin(usersModel);
        if(data!=null)

                response.setMessage("Login Successfully");
        else
            response.setMessage("Login Failed");
        response.setData(data);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
}
