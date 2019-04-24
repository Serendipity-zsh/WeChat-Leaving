package com.imooc.demo1.zhangdemotest.service.impl;

import com.imooc.demo1.zhangdemotest.dao.TeacherDao;
import com.imooc.demo1.zhangdemotest.entity.Teacher;
import com.imooc.demo1.zhangdemotest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getTeacherList() {
        return teacherDao.queryTeacher();
    }

    @Override
    public Teacher getTeacherById(String TeacherId) {
        return teacherDao.queryTeacherById(TeacherId);
    }

    @Override
    public String queryTeacherNameById(String TeacherId) { return teacherDao.queryTeacherNameById(TeacherId); }

    @Override
    public boolean login2(String id,String name){

        Teacher teacher = teacherDao.queryTeacherByIdName(id,name);
        if (teacher != null){
            return true;
        }
        return false;

    }

    @Transactional
    @Override
    public boolean addTeacher(Teacher teacher){
        //控制判断，主要是判断Tname不为空
        if (teacher.getTeacherName() != null && !"".equals(teacher.getTeacherName())) {
            //设置默认值
            teacher.setTeacherName(new String());
            try {
                int effectedNum = teacherDao.insertTeacher(teacher);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加老师信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加老师信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("老师Tname不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyTeacher(Teacher teacher) {
        //空值判断，主要是判断TeacherId不为空
        if (teacher.getTeacherId()!=null && !"".equals(teacher.getTeacherId())) {
            //设置默认值
            teacher.setTeacherId(new String());
            try {
                int effectedNum = teacherDao.updateTeacher(teacher);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新老师信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新老师信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("老师TeacherId不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteTeacher(String TeacherId) {
        if (TeacherId.isEmpty()|| TeacherId.length() < 7 ) {
            try {
                //删除老师信息
                int effectedNum = teacherDao.deleteTeacher(TeacherId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除老师信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除老师信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("老师TeacherId不能为空！");
        }
    }
}

