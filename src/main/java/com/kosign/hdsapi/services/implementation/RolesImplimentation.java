package com.kosign.hdsapi.services.implementation;

import com.kosign.hdsapi.models.RolesModel;
import com.kosign.hdsapi.repositories.RolesRepo;
import com.kosign.hdsapi.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RolesImplimentation implements RolesService {
    private RolesRepo rolesRepo;
    @Autowired
    public void setRolesRepo(RolesRepo rolesRepo){this.rolesRepo=rolesRepo;}
    @Override
    public List<RolesModel> getRoles() {
        return rolesRepo.getRoles();
    }
}
