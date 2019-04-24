package com.imooc.demo1.zhangdemotest.service.impl;

import com.imooc.demo1.zhangdemotest.dao.AdminDao;
import com.imooc.demo1.zhangdemotest.entity.Admin;
import com.imooc.demo1.zhangdemotest.entity.Teacher;
import com.imooc.demo1.zhangdemotest.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> getAdminList() {
        return adminDao.queryAdmin();
    }

    @Override
    public Admin getAdminById(String AdminId) {
        return adminDao.queryAdminById(AdminId);
    }

    @Override
    public boolean login4(String id,String name){

        Admin admin = adminDao.queryAdminByIdName(id, name);
        if (admin != null){
            return true;
        }
        return false;

    }

    @Override
    public String queryAdminNameById(String AdminId){
        return adminDao.queryAdminNameById(AdminId);
    }
    @Transactional
    @Override
    public boolean addAdmin(Admin admin){
        //控制判断，主要是判断Aname不为空
        if (admin.getAdminName() != null && !"".equals(admin.getAdminName())) {
            //设置默认值
            admin.setAdminName(new String());
            try {
                int effectedNum = adminDao.insertAdmin(admin);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加管理员信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加管理员信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("学生管理员不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyAdmin(Admin admin) {
        //空值判断，主要是判断AdminId不为空
        if (admin.getAdminId()!= null && !"".equals(admin.getAdminId())) {
            //设置默认值
            admin.setAdminId(new String());
            try {
                int effectedNum = adminDao.updateAdmin(admin);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新管理员信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新管理员信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("学生管理员不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteAdmin(String AdminId) {
        if (AdminId.isEmpty() || AdminId.length() < 7) {
            try {
                //删除管理员信息
                int effectedNum = adminDao.deleteAdmin(AdminId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除管理员信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除管理员信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("管理员AdminId不能为空！");
        }
    }
}
