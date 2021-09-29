package com.kosign.hdsapi.repositories.provider;

import org.apache.ibatis.jdbc.SQL;

public class UsersProvider {
    public String selectUserByUsernameSql() {
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("username = #{username}");
        }}.toString();
    }

}
