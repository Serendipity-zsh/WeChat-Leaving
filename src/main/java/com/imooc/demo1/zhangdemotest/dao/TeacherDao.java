package com.imooc.demo1.zhangdemotest.dao;

import com.imooc.demo1.zhangdemotest.entity.Teacher;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {
    /**
     * 列出老师信息
     * @return AreaList
     */
    List<Teacher> queryTeacher();

    /**
     * 根据TeacherId列出具体老师信息
     * @return Teacher
     */
    Teacher queryTeacherById(String teacherId);

    /**
     * 根据TeacherId列出具体老师姓名
     * @return
     */
    String queryTeacherNameById(String teacherId);

    /**
     * 插入老师信息
     * @param teacher
     * @return
     */
    int insertTeacher(Teacher teacher);

    /**
     *更新老师信息
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 删除老师信息
     * @param teacherId
     * @return
     */
    int deleteTeacher(String teacherId);

    /**
     * 根据teacherId和teacherName列出具体老师信息
     * @return Student
     */
    Teacher queryTeacherByIdName(String teacherId, String teacherName);
}
