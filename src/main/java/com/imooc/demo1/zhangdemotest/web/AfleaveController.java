package com.imooc.demo1.zhangdemotest.web;

import com.imooc.demo1.zhangdemotest.entity.Afleave;
import com.imooc.demo1.zhangdemotest.service.AfleaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class AfleaveController {
    @Autowired
    AfleaveService afleaveService;

    /**
     * 显示请假条列表
     * @return
     */
    @RequestMapping(value = "/listafleave")
    private Map<String, Object> listAfleave() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Afleave> list = new ArrayList<>();
        // 获取区域列表
        list = afleaveService.getAfleaveList();
        modelMap.put("afleavelist", list);
        return modelMap;
    }

    /**
     * 保存请假条信息
     */
    @RequestMapping(value = "/saveAfleave",method = RequestMethod.POST)
    private Map<String,Object> addAfleave(@RequestBody Afleave afleave) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", afleaveService.addAfleave(afleave));
        return modelMap;
    }

    /**
     * 根据请假条ID获取信息
     * @param
     */
    @RequestMapping(value = "/getAfleaveById", method = RequestMethod.GET)
    private Map<String, Object> getAdminById(String afleaveId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
         Afleave afleave=afleaveService.getAfleaveById(afleaveId);
        modelMap.put("afleave", afleave);
        return modelMap;
    }

    /**
     * 根据学生ID获取请假条信息
     */
    @RequestMapping(value = "/getAfleaveByStudentId", method = RequestMethod.GET)
    private Map<String, Object> getAfleaveByStudentId(String studentId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Afleave afleave = afleaveService.getAfleaveByStudentId(studentId);
        modelMap.put("afleave", afleave);
        return modelMap;
    }
}
