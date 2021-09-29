package com.kosign.hdsapi.repositories.provider;

import org.apache.ibatis.jdbc.SQL;

public class RolesProvider {
    public String getRoles(){
        return new SQL(){{
            SELECT("*");
            FROM("roles");
        }}.toString();
    }
}
