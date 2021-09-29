package com.kosign.hdsapi.repositories;

import com.kosign.hdsapi.models.RolesModel;
import com.kosign.hdsapi.repositories.provider.RolesProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RolesRepo {
    @SelectProvider(value = RolesProvider.class, method = "getRoles")
    List<RolesModel> getRoles();
}
