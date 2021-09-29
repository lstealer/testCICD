package com.kosign.hdsapi.services;

import com.kosign.hdsapi.models.RolesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolesService {
    List<RolesModel> getRoles();
}
