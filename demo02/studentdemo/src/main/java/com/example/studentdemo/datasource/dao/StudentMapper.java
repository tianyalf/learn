package com.example.studentdemo.datasource.dao;

import com.example.studentdemo.datasource.entity.Student;
import com.example.studentdemo.datasource.entity.StudentCriteria;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentMapper {
    long countByExample(StudentCriteria example);

    int deleteByExample(StudentCriteria example);

    int deleteByPrimaryKey(String sno);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExampleWithRowbounds(StudentCriteria example, RowBounds rowBounds);

    List<Student> selectByExample(StudentCriteria example);

    Student selectByPrimaryKey(String sno);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectStudentsByPage(HashMap<String, Object> paramMap);

    int selectTotal();
}