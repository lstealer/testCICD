package com.kosign.hdsapi.repositories;

import com.kosign.hdsapi.models.RolesModel;
import com.kosign.hdsapi.models.UsersModel;
import com.kosign.hdsapi.repositories.provider.UsersProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("userRepository")
public interface UsersRepository {
    @SelectProvider(type = UsersProvider.class, method = "selectUserByUsernameSql")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "role_id",
                    property = "roles",
                    many = @Many(select = "selectRolesByUserId"))
    })
    UsersModel selectUserByUsername(String username);

    @Select("select  r.role from roles r\n" +
            "inner join users ur on r.role_id = ur.role_id\n" +
            "where ur.user_id = ${id}")
    List<RolesModel> selectRolesByUserId(int id);

    @Insert("INSERT INTO users(username,password,email,department) " +
            "VALUES ( '${username}' , '${password}' , '${email}' , '${department}')")
    boolean insertNewUser(UsersModel usersModel);
    @Select("SELECT * FROM users WHERE username='${username}' AND password='${password}'")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "username", property = "username"),
            @Result(column = "role_id",
                    property = "roles",
                    many = @Many(select = "selectRolesByUserId"))
    })
    UsersModel userLogin(String username,String password);

    @Select("SELECT username FROM users WHERE username='${name}'")
    String  usernameCheck(String name);
}
