package com.zc.dao;

import com.zc.pojo.Student;
import com.zc.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Select(value = "select * from teacher where id = #{id}")
    Teacher getTeacherById(@Param("id") int id);
}
