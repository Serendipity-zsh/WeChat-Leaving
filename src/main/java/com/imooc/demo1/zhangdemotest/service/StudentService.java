package com.imooc.demo1.zhangdemotest.service;


import com.imooc.demo1.zhangdemotest.entity.Student;


import java.util.List;

public interface StudentService {

    /**
     * 获取学生列表
     *
     * @return studentList
     */
    List<Student> getStudentList();

    /**
     * 根据studentId获取学生信息
     * @param studentId
     * @return
     */
    Student getStudentById(String studentId);

    /**
     * 根据studentId列出具体学生姓名
     * @return
     */
    String queryStudentNameById(String studentId);

    /**
     * 增加学生信息
     * @param student
     * @return
     */
    boolean addStudent(Student student);

    /**
     *修改学生信息
     * @param student
     * @return
     */
    boolean modifyStudent(Student student);

    /**
     * 删除学生信息
     * @param studentId
     * @return
     */
    boolean deleteStudent(String studentId);

    /**
     *认证学生
     */
    boolean login1(String id,String name);
}
