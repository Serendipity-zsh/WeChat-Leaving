package com.imooc.demo1.zhangdemotest.web;

import com.imooc.demo1.zhangdemotest.entity.Counsellor;
import com.imooc.demo1.zhangdemotest.service.CounsellorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class CounsellorController {
    @Autowired
    CounsellorService counsellorService;
    /**
     * 显示辅导员列表
     * @return
     */
    @RequestMapping(value = "/listcounsellor")
    private Map<String, Object> listCounsellor() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Counsellor> list = new ArrayList<>();
        // 获取区域列表
        list = counsellorService.getCounsellorList();
        modelMap.put("counsellorList", list);
        return modelMap;
    }

    /**
     * 根据辅导员ID获取信息
     * @param counsellorId
     * @return
     */
    @RequestMapping(value = "/getCounsellorById", method = RequestMethod.GET)
    private Map<String, Object> getAdminById(String counsellorId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Counsellor counsellor = counsellorService.getCounsellorById(counsellorId);
        modelMap.put("counsellor", counsellor);
        return modelMap;
    }
}
