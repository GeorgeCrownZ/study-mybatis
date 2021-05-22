package com.zc.dao;

import com.zc.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from mybatis.user")
    List<User> getUserList();

    @Select("select * from mybatis.user where id = #{id}")
    User getUserById(int id);

    @Delete("delete from mybatis.user where id = #{id}")
    int deleteUserById(int id);

    @Insert("insert into mybatis.user (id, name, password) values (#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update mybatis.user set name = #{name}, password = #{password} where id = #{id}")
    int updateUserById(User user);
}
