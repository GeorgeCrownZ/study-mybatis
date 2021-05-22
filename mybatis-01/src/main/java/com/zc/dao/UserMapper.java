package com.zc.dao;

import com.zc.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    @Select("select * from mybatis.user where id = #{id}")
    User getUserById(int id);

    @Delete("delete from mybatis.user where id = #{id}")
    int deleteUserById(int id);

    @Insert("insert into mybatis.user (id, name, password) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update mybatis.user set name = #{name}, password = #{password} where id = #{id}")
    int updateUserById(User user);

    @Insert("insert into mybatis.user (id, name, password) values (#{id}, #{name}, #{password})")
    int addUser2(Map<String,Object> map);

    @Select("select * from mybatis.user where name like %")
    List<User> getUserLike(String name);
}
