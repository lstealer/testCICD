package com.kosign.hdsapi.controllers;

import com.kosign.hdsapi.models.BaseApiResponseModel;
import com.kosign.hdsapi.models.RolesModel;
import com.kosign.hdsapi.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RolesController {
    private RolesService rolesService;

    @Autowired
    public void setRolesService(RolesService rolesService){ this.rolesService = rolesService;}
    @GetMapping("/roles")
    public ResponseEntity<BaseApiResponseModel<List<RolesModel>>> getModel(){
        BaseApiResponseModel<List<RolesModel>> response = new BaseApiResponseModel<>();
        response.setMessage("You have got all roles successfully!");
        response.setData(rolesService.getRoles());
        response.setStatus(HttpStatus.OK);
        response.setTime( new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
}
