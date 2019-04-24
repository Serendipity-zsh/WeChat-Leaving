package com.imooc.demo1.zhangdemotest.service.impl;


import com.imooc.demo1.zhangdemotest.dao.CounsellorDao;
import com.imooc.demo1.zhangdemotest.entity.Counsellor;
import com.imooc.demo1.zhangdemotest.service.CounsellorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CounsellorServiceImpl implements CounsellorService {
    @Autowired
    private CounsellorDao counsellorDao;

    @Override
    public List<Counsellor> getCounsellorList() {
        return counsellorDao.queryCounsellor();
    }

    @Override
    public Counsellor getCounsellorById(String CounsellorId) {
        return counsellorDao.queryCounsellorById(CounsellorId);
    }

    @Override
    public String queryCounsellorNameById(String CounsellorId)
    {
       return  counsellorDao.queryCounsellorNameById(CounsellorId);
    }

    @Override
    public boolean login3(String id,String name){

        Counsellor counsellor = counsellorDao.queryCounsellorByIdName(id,name);
        if (counsellor != null){
            return true;
        }
        return false;

    }

    @Transactional
    @Override
    public boolean addCounsellor(Counsellor counsellor){
        //控制判断，主要是判断Cname不为空
        if (counsellor.getCounsellorName() != null && !"".equals(counsellor.getCounsellorName())) {
            //设置默认值
            counsellor.setCounsellorName(new String());
            try {
                int effectedNum = counsellorDao.insertCounsellor(counsellor);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加辅导员信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加辅导员信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("辅导员Cname不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyCounsellor(Counsellor counsellor) {
        //空值判断，主要是判断CounsellorId不为空
        if (counsellor.getAdminId()!=null && !"".equals(counsellor.getAdminId())) {
            //设置默认值
            counsellor.setCounsellorId(new String());
            try {
                int effectedNum = counsellorDao.updateCounsellor(counsellor);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新辅导员信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新辅导员信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("辅导员CounsellorId不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteCounsellor(String CounsellorId) {
        if (CounsellorId.isEmpty()|| CounsellorId.length() < 7 ) {
            try {
                //删除辅导员信息
                int effectedNum = counsellorDao.deleteCounsellor(CounsellorId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除辅导员信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除辅导员信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("辅导员CounsellorId不能为空！");
        }
    }
}
