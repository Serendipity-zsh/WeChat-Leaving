package com.imooc.demo1.zhangdemotest.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.demo1.zhangdemotest.entity.StudentAfleave;
import com.imooc.demo1.zhangdemotest.service.StudentAfleaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

@RestController
public class StudentAfleaveController {
    @Autowired
    StudentAfleaveService studentAfleaveService;
    /**
     * 根据学生ID获取请假信息
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/getStudentAfleaveByStudentId", method = RequestMethod.GET)
    private Map<String, Object> getStudentAfleaveByStudentId(String studentId) {
        System.out.println("获取请假信息:"+studentId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<StudentAfleave> list = studentAfleaveService.getStudentAfleaveByStudentId(studentId);
        modelMap.put("studentAfleave", list);
        return modelMap;
    }

    /**
     * 根据学生ID获取请假条状态为“已提交”的请假条的信息
     * @param studentId
     * @return
     */
    @RequestMapping(value = "/getStudentAfleaveByStudentIdAndState", method = RequestMethod.GET)
    private Map<String, Object> getStudentAfleaveByStudentIdAndState(String studentId) {
        System.out.println("获取请假信息(state):"+studentId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<StudentAfleave> list = studentAfleaveService.getStudentAfleaveByStudentIdAndState(studentId);
        modelMap.put("studentAfleave", list);
        return modelMap;
    }

    /**
     * 根据请假条ID获取请假信息
     */
    @RequestMapping(value = "getStudentAfleaveById", method = RequestMethod.GET)
    private Map<String, Object> getStudentAfleaveById(String studentAfleaveId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        StudentAfleave studentAfleave = studentAfleaveService.getStudentAfleaveById(studentAfleaveId);
        modelMap.put("studentAfleave", studentAfleave);
        return modelMap;
    }
    /**
     * 获取学生请假条列表
     */
    @RequestMapping(value = "/listStudentAfleave", method = RequestMethod.GET)
    private Map<String, Object> listAfleave() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<StudentAfleave> list = new ArrayList<>();
        // 获取请假条列表
        list = studentAfleaveService.getStudentAfleaveList();
        modelMap.put("studentAfleave", list);
        return modelMap;
    }

    /**
     * 添加学生请假条
     */
    @RequestMapping(value = "/addStudentAfleave", method = RequestMethod.POST)
    private Map<String, Object> addStudentAfleave(@RequestBody StudentAfleave studentAfleave)
        throws JsonMappingException, JsonParseException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", studentAfleaveService.addStudentAfleave(studentAfleave));
        return modelMap;
    }


    /**
     * 添加学生请假条
     */
    @RequestMapping(value = "/addStudentAfleave1", method = RequestMethod.POST)
    private Map<String, Object> addStudentAfleave(int studentAfleaveId, String studentId, String counsellorId, String studentAname, String studentClass, String studentNumber, Date studentAfleaveStartTime, Date studentAfleaveEndTime, int studentAfleaveDays, String studentAfleavePlace, String studentAfleaveReason, String studentAfleaveState)
            throws JsonMappingException, JsonParseException, IOException {
        System.out.println(studentAfleaveId+studentId+counsellorId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", studentAfleaveService.addStudentAfleave1(studentAfleaveId,studentId, counsellorId,  studentAname,  studentClass,  studentNumber, studentAfleaveStartTime, studentAfleaveEndTime,studentAfleaveDays, studentAfleavePlace, studentAfleaveReason, studentAfleaveState));
        return modelMap;
    }


    /**
     * 更新学生请假条状态信息
     */
    @RequestMapping(value = "/modifyStudnetAfleave", method = RequestMethod.POST)
    private Map<String, Object> modifyStudnetAfleave(@RequestBody StudentAfleave studentAfleave)
    throws JsonMappingException, JsonParseException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", studentAfleaveService.modifyStudentAfleave(studentAfleave));
        return modelMap;
    }
    /**
     * 更新学生请假条状态信息(根据请假条ID,修改state）
     */
    @RequestMapping(value = "/modifyStudnetAfleave1", method = RequestMethod.POST)
    private Map<String, Object> modifyStudnetAfleave1(int studentAfleaveId,String studentAfleaveState)
            throws JsonMappingException, JsonParseException, IOException {

        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", studentAfleaveService.modifyStudentAfleave1(studentAfleaveId,studentAfleaveState));
        return modelMap;
    }


}
