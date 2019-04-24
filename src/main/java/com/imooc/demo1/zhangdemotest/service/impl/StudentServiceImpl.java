package com.imooc.demo1.zhangdemotest.service.impl;

import com.imooc.demo1.zhangdemotest.dao.StudentDao;

import com.imooc.demo1.zhangdemotest.entity.Student;
import com.imooc.demo1.zhangdemotest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层接口实现
 *
 * 1.业务层Bean用@Service标注
 * 2.当前Bean的名称是"autowiredStudentServiceImpl"
 * 3.设置当前Bean的为原型模式，即每次获取Bean时都创建一个新实例
 * 4.业务层有一个数据层接口IDao，使用@Autowired注解标注
 * */

@Service("autowiredStudentServiceImpl")
@Scope("prototype")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentList() {
        return studentDao.queryStudent();
    }

    @Override
    public Student getStudentById(String StudentId) {
        return studentDao.queryStudentById(StudentId);
    }


    @Override
    public boolean login1(String id,String name){

        Student stduent = studentDao.queryStudentByIdName(id,name);
        if (stduent != null){
            return true;
        }
        return false;

    }

    @Override
    public String queryStudentNameById(String studentId) {return  studentDao.queryStudentNameById(studentId);}
    @Transactional
    @Override
    public boolean addStudent(Student student){
        //控制判断，主要是判断Sname不为空
        if (student.getStudentName() != null && !"".equals(student.getStudentName())) {
            //设置默认值
            student.setStudentName(new String());
            try {
                int effectedNum = studentDao.insertStudent(student);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加学生信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加学生信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("学生信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyStudent(Student student) {
        //空值判断，主要是判断StudentId不为空
        if (student.getStudentId()!= null && !"".equals(student.getStudentId())) {
            //设置默认值
            student.setStudentId(new String());
            try {
                int effectedNum = studentDao.updateStudent(student);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新学生信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新学生信息失败：" + e.toString());
            }
        }else {
            throw new RuntimeException("学生信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteStudent(String StudentId) {
        if (StudentId.isEmpty() || StudentId.length() < 13) {
            try {
                //删除学生信息
                int effectedNum = studentDao.deleteStudent(StudentId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除学生信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除学生信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("学生StudentId不能为空！");
        }
    }
}
