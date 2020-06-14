package com.example.studentdemo.atom;

import com.example.studentdemo.datasource.entity.Student;
import com.example.studentdemo.datasource.entity.StudentCriteria;

import java.util.HashMap;
import java.util.List;

/**
 * @date:2020-06-13 15:00
 * @author:天涯沦落人
 * @description:
 */
public interface IStudentAtom{
    List<Student> selectByExample(StudentCriteria example);

    Student selectByPrimaryKey(String sno);

    int insert(Student record);

    int updateByPrimaryKey(Student record);

    int deleteByPrimaryKey(String sno);

    List<Student> queryStudentsByPage(HashMap<String, Object> paramMap);

    int queryTotal();
}
