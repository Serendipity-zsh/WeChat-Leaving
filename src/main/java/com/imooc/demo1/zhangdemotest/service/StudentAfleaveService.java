package com.imooc.demo1.zhangdemotest.service;

import com.imooc.demo1.zhangdemotest.entity.StudentAfleave;

import java.util.List;

public interface StudentAfleaveService {
    /**
     * 获取请假条列表
     *
     * @return Afleave
     */
    List<StudentAfleave> getStudentAfleaveList();

    /**
     * 根据StudentAfleaveId获取请假条信息
     * @param studentAfleaveId
     * @return
     */
    StudentAfleave getStudentAfleaveById(String studentAfleaveId);

    /**
     * 根据学生ID获取请假条信息
     */
    List<StudentAfleave> getStudentAfleaveByStudentId(String studentId);

    /**
     * 增加学生请假条信息
     * @param studentAfleave
     * @return
     */
    boolean addStudentAfleave(StudentAfleave studentAfleave);

    /**
     *修改请假条信息
     * @param studentAfleave
     * @return
     */
    boolean modifyStudentAfleave(StudentAfleave studentAfleave);
//
//    /**
//     * 删除请假条信息
//     * @param studentAfleaveId
//     * @return
//     */
//    boolean deleteStudentAfleave(String studentAfleaveId);
}
