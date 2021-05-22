package com.zc.dao;

import com.zc.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    List<Student> getStudent();
    List<Student> getStudent2();
}
