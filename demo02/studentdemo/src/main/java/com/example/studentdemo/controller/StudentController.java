package com.example.studentdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.constant.Constants;
import com.example.studentdemo.datasource.entity.Student;
import com.example.studentdemo.datasource.entity.StudentCriteria;
import com.example.studentdemo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @date:2020-06-13 12:26
 * @author:天涯沦落人
 * @description:
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    /**
     * 查找所有学生
     *
     * @return
     */
    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents() {
        StudentCriteria studentCriteria = new StudentCriteria();
        studentCriteria.setOrderByClause("createtime");
        return studentService.selectByExample(studentCriteria);
    }

    /**
     * 根据主键查找学生
     *
     * @param student
     * @return
     */
    @PostMapping("/findByPrimaryKey")
    public Student findStudentByPrimaryKey(@RequestBody Student student) {
        Student res = null;
        try {
            res = studentService.selectByPrimaryKey(student.getSno());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @PostMapping("/addStudent")
    public int addStudent(@RequestBody Student student) {
        int res = 0;
        try {
            student.setSno(UUID.randomUUID().toString().replaceAll("-", "").toLowerCase());
            student.setCreatetime(new Date());
            student.setDelTag(Constants.DEL_TAG_1);
            res = studentService.insert(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据主键更新学生信息
     *
     * @param student
     * @return
     */
    @PostMapping("/updateStudentByPrimaryKey")
    public int updateStudent(@RequestBody Student student) {
        int res = 0;
        try {
            student.setUpdatetime(new Date());
            res = studentService.updateByPrimaryKey(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 根据主键删除学生（调用delete删除）
     *
     * @param student
     * @return
     */
    @PostMapping("/deleteStudentByPrimaryKey")
    public int deleteStudent(@RequestBody Student student) {
        int res = 0;
        try {
            student.setUpdatetime(new Date());
            student.setDelTag(Constants.DEL_TAG_0);
            res = studentService.deleteByPrimaryKey(student.getSno());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping("/queryStudentsByPage")
    public JSONObject queryStudentsByPage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                                             @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        HashMap<String, Object> paramMap = new HashMap<>(8);
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageSize", pageSize);
        //查询所有数据
        List<Student> students = studentService.queryStudentsByPage(paramMap);
        //查询数据条数
        int total=studentService.queryTotal();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dataList",students);
        jsonObject.put("total",total);
        return jsonObject;
    }
}
