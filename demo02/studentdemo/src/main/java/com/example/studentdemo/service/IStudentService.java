package com.example.studentdemo.service;

import com.example.studentdemo.datasource.entity.Student;
import com.example.studentdemo.datasource.entity.StudentCriteria;

import java.util.HashMap;
import java.util.List;

/**
 * @date:2020-06-13 12:26
 * @author:天涯沦落人
 * @description:
 */
public interface IStudentService {

    List<Student> selectByExample(StudentCriteria example);

    Student selectByPrimaryKey(String sno);

    int insert(Student record);

    int updateByPrimaryKey(Student record);

    int deleteByPrimaryKey(String sno);

    List<Student> queryStudentsByPage(HashMap<String, Object> paramMap);

    int queryTotal();
}
