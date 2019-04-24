package com.imooc.demo1.zhangdemotest.service;

import com.imooc.demo1.zhangdemotest.entity.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 获取管理员列表
     *
     * @return AdminList
     */
    List<Admin> getAdminList();

    /**
     * 根据AdminId获取管理员信息
     * @param adminId
     * @return
     */
    Admin getAdminById(String adminId);

    /**
     * 根据AdminId列出具体管理员姓名
     * @return Aname
     */
    String queryAdminNameById(String adminId);
    /**
     * 增加管理员信息
     * @param admin
     * @return
     */
    boolean addAdmin(Admin admin);

    /**
     *修改管理员信息
     * @param admin
     * @return
     */
    boolean modifyAdmin(Admin admin);

    /**
     * 删除管理员信息
     * @param adminId
     * @return
     */
    boolean deleteAdmin(String adminId);

    /**
     *认证管理员
     */
    boolean login4(String id,String name);
}
