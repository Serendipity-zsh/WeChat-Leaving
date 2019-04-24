package com.imooc.demo1.zhangdemotest.entity;

public class Admin {
    private String adminId;
    private String adminName;
    private String adminSex;
    private String adminDepartment;
    private String adminOpenid;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String AdminId) {
        adminId = AdminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public String getAdminDepartment() {
        return adminDepartment;
    }

    public void setAdminDepartment(String adminDepartment) {
        this.adminDepartment = adminDepartment;
    }

    public String getAdminOpenid() {
        return adminOpenid;
    }

    public void setAdminOpenid(String adminOpenid) {
        this.adminOpenid = adminOpenid;
    }
}
