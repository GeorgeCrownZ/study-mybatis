package com.zc.dao;

import com.zc.pojo.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    //  column对应数据库中的字段，property对应实体类中的字段
    //@Results(id = "UserMap" , value = {@Result(property = "pwd",column = "password")})
    @ResultMap("UserMap")
    @Select(value = "select * from mybatis.user where id = #{id}")
    User getUserById(int id);
}
