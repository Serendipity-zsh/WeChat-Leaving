package com.imooc.demo1.zhangdemotest.web;

import com.imooc.demo1.zhangdemotest.entity.Admin;
import com.imooc.demo1.zhangdemotest.entity.Counsellor;
import com.imooc.demo1.zhangdemotest.entity.Student;
import com.imooc.demo1.zhangdemotest.entity.Teacher;
import com.imooc.demo1.zhangdemotest.service.AdminService;
import com.imooc.demo1.zhangdemotest.service.CounsellorService;
import com.imooc.demo1.zhangdemotest.service.StudentService;
import com.imooc.demo1.zhangdemotest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class WXLoginController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    CounsellorService counsellorService;
    @Autowired
    AdminService adminService;


    /**
     * 通过id和name判断用户的身份并返回对应用户信息
     * 身份是学生返回1
     * 身份是老师返回2
     * 身份是辅导员返回3
     * 身份是管理员返回4
     * 身份不合法返回0
     * @return
     */
    @RequestMapping("/login")
    private Map<String, Object> getlogin(String id,String name) {
        System.out.println("登陆");
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        int flag = 0;
        boolean flag1 = studentService.login1(id,name);
        boolean flag2 = teacherService.login2(id, name);
        boolean flag3 = counsellorService.login3(id, name);
        boolean flag4 = adminService.login4(id, name);

        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (flag1) {
            flag=1;
            Student student=studentService.getStudentById(id);
            modelMap.put("flag", flag);
            modelMap.put("student", student);
        }
        if(flag2){
            flag=2;
            Teacher teacher = teacherService.getTeacherById(id);
            modelMap.put("flag", flag);
            modelMap.put("teacher", teacher);
        }
        if(flag3){
            flag=3;
            Counsellor counsellor = counsellorService.getCounsellorById(id);
            modelMap.put("flag", flag);
            modelMap.put("counsellor", counsellor);
        }
        if(flag4){
            flag=4;
            Admin admin = adminService.getAdminById(id);
            modelMap.put("flag", flag);
            modelMap.put("admin", admin);
        }
        if (flag == 0) {
            modelMap.put("flag", flag);
        }
        return modelMap;
    }
}
