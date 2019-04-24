package com.imooc.demo1.zhangdemotest.service;

import com.imooc.demo1.zhangdemotest.entity.Teacher;


import java.util.List;

public interface TeacherService {
    /**
     * 获取老师列表
     *
     * @return TeacherList
     */
    List<Teacher> getTeacherList();

    /**
     * 根据TeacherId获取老师信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherById(String teacherId);

    /**
     * 根据TeacherId列出具体老师姓名
     * @return
     */
    String queryTeacherNameById(String teacherId);

    /**
     * 增加老师信息
     * @param teacher
     * @return
     */
    boolean addTeacher(Teacher teacher);

    /**
     *修改老师信息
     * @param teacher
     * @return
     */
    boolean modifyTeacher(Teacher teacher);

    /**
     * 删除老师信息
     * @param teacherId
     * @return
     */
    boolean deleteTeacher(String teacherId);

    /**
     *认证老师
     */
    boolean login2(String id,String name);
}
