package com.imooc.demo1.zhangdemotest.web;

import com.imooc.demo1.zhangdemotest.entity.Teacher;
import com.imooc.demo1.zhangdemotest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    /**
     * 显示老师列表
     * @return
     */
    @RequestMapping(value = "/listteacher", method = RequestMethod.GET)
    private Map<String, Object> listteacher() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Teacher> list = new ArrayList<>();
        // 获取区域列表
        list = teacherService.getTeacherList();
        modelMap.put("teacherList", list);
        return modelMap;
    }

    /**
     * 根据老师ID获取信息
     * @param teacherId
     * @return
     */
    @RequestMapping(value = "/getTeacherById", method = RequestMethod.GET)
    private Map<String, Object> getTeacherById(String teacherId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Teacher teacher=teacherService.getTeacherById(teacherId);
        modelMap.put("teacher", teacher);
        return modelMap;
    }
}
