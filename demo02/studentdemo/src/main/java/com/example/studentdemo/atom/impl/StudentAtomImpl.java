package com.example.studentdemo.atom.impl;

import com.example.studentdemo.atom.IStudentAtom;
import com.example.studentdemo.datasource.dao.StudentMapper;
import com.example.studentdemo.datasource.entity.Student;
import com.example.studentdemo.datasource.entity.StudentCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @date:2020-06-13 14:59
 * @author:天涯沦落人
 * @description:
 */
@Component
@Slf4j
public class StudentAtomImpl implements IStudentAtom {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectByExample(StudentCriteria example) {
        return studentMapper.selectByExample(example);
    }

    @Override
    public Student selectByPrimaryKey(String sno) {
        return studentMapper.selectByPrimaryKey(sno);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(String sno) {
        return studentMapper.deleteByPrimaryKey(sno);
    }

    @Override
    public List<Student> queryStudentsByPage(HashMap<String, Object> paramMap) {
        return studentMapper.selectStudentsByPage(paramMap);
    }

    @Override
    public int queryTotal() {
        return studentMapper.selectTotal();
    }
}
