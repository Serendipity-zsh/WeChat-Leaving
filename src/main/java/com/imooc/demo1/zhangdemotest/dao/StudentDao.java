package com.imooc.demo1.zhangdemotest.dao;

import com.imooc.demo1.zhangdemotest.entity.Student;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据层接口，用于访问数据库，返回数据给业务层
 * */
@Repository
public interface StudentDao {
    /**
     * 列出学生信息
     * @return AreaList
     */
    List<Student> queryStudent();

    /**
     * 根据studentId列出具体学生信息
     * @return Student
     */
    Student queryStudentById(String studentId);

    /**
     * 根据studentId列出具体学生姓名
     * @return
     */
    String queryStudentNameById(String studentId);

    /**
     * 插入学生信息
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     *更新学生信息
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 删除学生信息
     * @param StudentId
     * @return
     */
    int deleteStudent(String StudentId);

    /**
     * 根据studentId和studentName列出具体学生信息
     * @return Student
     */
    Student queryStudentByIdName(String studentId,String studentName);
}
