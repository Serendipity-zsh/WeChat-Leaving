package com.imooc.demo1.zhangdemotest.web;

import com.imooc.demo1.zhangdemotest.entity.Admin;
import com.imooc.demo1.zhangdemotest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    /**
     * 显示管理员列表
     * @return
     */
    @RequestMapping(value = "/listadmin")
    private Map<String, Object> listAdmin() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Admin> list = new ArrayList<Admin>();
        // 获取区域列表
        list = adminService.getAdminList();
        modelMap.put("adminList", list);
        return modelMap;
    }

    /**
     * 根据管理员ID获取管理员信息
     */
    @RequestMapping(value = "/getAdminById", method = RequestMethod.GET)
    private Map<String, Object> getAdminById(String adminId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Admin admin=adminService.getAdminById(adminId);
        modelMap.put("admin", admin);
        return modelMap;
    }

}
