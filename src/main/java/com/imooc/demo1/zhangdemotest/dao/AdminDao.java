package com.imooc.demo1.zhangdemotest.dao;


import com.imooc.demo1.zhangdemotest.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    /**
     * 列出管理员信息
     * @return AreaList
     */
    List<Admin> queryAdmin();

    /**
     * 根据AdminId列出具体管理员信息
     * @return Admin
     */
    Admin queryAdminById(String AdminId);


    /**
     * 根据AdminId列出具体管理员姓名
     * @return
     */
    String queryAdminNameById(String AdminId);


    /**
     * 插入管理员信息
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     *更新管理员信息
     * @param admin
     * @return
     */
    int updateAdmin(Admin admin);

    /**
     * 删除管理员信息
     * @param AdminId
     * @return
     */
    int deleteAdmin(String AdminId);

    /**
     * 根据adminId和adminName列出具体老师信息
     * @return Admin
     */
    Admin queryAdminByIdName(String adminId, String adminName);
}
