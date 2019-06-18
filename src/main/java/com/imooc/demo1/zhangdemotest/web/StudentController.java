package com.imooc.demo1.zhangdemotest.web;

import com.imooc.demo1.zhangdemotest.entity.Student;
import com.imooc.demo1.zhangdemotest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * 显示学生列表
     * @return
     */
    @RequestMapping(value = "/liststudent", method = RequestMethod.GET)
    private Map<String, Object> liststudent() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Student> list = new ArrayList<>();
        // 获取学生列表
        list = studentService.getStudentList();
        modelMap.put("studentList", list);
        return modelMap;
    }

    /**
     * 通过学生ID获取学生信息
     */
    @RequestMapping(value = "/getStudentById", method = RequestMethod.GET)
    private Map<String, Object> getStudentById(String studentId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Student student=studentService.getStudentById(studentId);
        System.out.println("获取学生信息："+studentId);
        modelMap.put("student", student);
        return modelMap;
    }
}
