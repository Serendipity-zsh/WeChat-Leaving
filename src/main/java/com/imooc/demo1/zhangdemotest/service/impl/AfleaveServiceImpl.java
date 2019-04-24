package com.imooc.demo1.zhangdemotest.service.impl;


import com.imooc.demo1.zhangdemotest.dao.AfleaveDao;
import com.imooc.demo1.zhangdemotest.entity.Afleave;
import com.imooc.demo1.zhangdemotest.service.AfleaveService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AfleaveServiceImpl implements AfleaveService {
    @Autowired
    private AfleaveDao afleaveDao;

    @Override
    public List<Afleave> getAfleaveList() {
        return afleaveDao.queryAfleave();
    }

    @Override
    public Afleave getAfleaveById(String afleaveId) {
        return afleaveDao.queryAfleaveById(afleaveId);
    }

    @Override
    public Afleave getAfleaveByStudentId(String studentId) {
        return afleaveDao.queryAfleaveByStudentId(studentId);
    }

    @Transactional
    @Override
    public boolean addAfleave(Afleave afleave){
        //控制判断，主要是判断Place不为空
        if (afleave.getPlace() != null && !"".equals(afleave.getPlace())) {
            //设置默认值
            afleave.setStartTime(new Date());
            afleave.setEndTime(new Date());
            try {
                int effectedNum = afleaveDao.insertAfleave(afleave);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加请假条信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加请假条信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("请假条地址不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyAfleave(Afleave afleave) {
        //空值判断，主要是判断AfleaveId不为空
        if (afleave.getAfleaveId()!=null && !"".equals(afleave.getAfleaveId())) {
            //设置默认值
            afleave.setAfleaveId(new String());
            try {
                int effectedNum = afleaveDao.updateAfleave(afleave);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新请假条信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新请假条信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("请假条AfleaveId不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteAfleave(String AfleaveId) {
        if (AfleaveId.isEmpty() ) {
            try {
                //删除管理员信息
                int effectedNum = afleaveDao.deleteAfleave(AfleaveId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除请假条信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除请假条信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("请假条AfleaveId不能为空！");
        }
    }
}
