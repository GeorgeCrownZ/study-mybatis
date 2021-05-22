package com.zc.dao;

import com.zc.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select(value = "select * from user")
    List<User> getUsers();

    //  方法存在多个参数，所有的参数前面必须加上@Param
    @Select(value = "select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert(value = "insert into user(id, name, password) values(#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update(value = "update user set name = #{name}, password = #{password} where id = #{id}")
    int updateUser(User user);

    @Delete(value = "delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
