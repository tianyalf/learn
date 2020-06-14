package com.example.studentdemo.service.impl;

import com.example.studentdemo.atom.IStudentAtom;
import com.example.studentdemo.datasource.dao.StudentMapper;
import com.example.studentdemo.datasource.entity.Student;
import com.example.studentdemo.datasource.entity.StudentCriteria;
import com.example.studentdemo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @date:2020-06-13 12:26
 * @author:天涯沦落人
 * @description:
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentAtom studentAtom;

    @Override
    public List<Student> selectByExample(StudentCriteria example) {
        return studentAtom.selectByExample(example);
    }

    @Override
    public Student selectByPrimaryKey(String sno) {
        if (sno == null) {
            throw new RuntimeException("学号不能为空");
        }
        return studentAtom.selectByPrimaryKey(sno);
    }

    @Override
    public int insert(Student record) {
        int result = studentAtom.insert(record);
        if (result <= 0) {
            throw new RuntimeException("添加学生失败");
        }
        return result;
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        int result = studentAtom.updateByPrimaryKey(record);
        if (result <= 0) {
            throw new RuntimeException("更新学生信息失败");
        }
        return result;
    }

    @Override
    public int deleteByPrimaryKey(String sno) {
        int result = studentAtom.deleteByPrimaryKey(sno);
        if (result <= 0) {
            throw new RuntimeException("删除学生信息失败");
        }
        return result;
    }

    @Override
    public List<Student> queryStudentsByPage(HashMap<String, Object> paramMap) {
        return studentAtom.queryStudentsByPage(paramMap);
    }

    @Override
    public int queryTotal() {
        return studentAtom.queryTotal();
    }
}
