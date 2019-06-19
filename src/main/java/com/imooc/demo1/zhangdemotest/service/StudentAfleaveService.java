package com.imooc.demo1.zhangdemotest.service;

import com.imooc.demo1.zhangdemotest.entity.StudentAfleave;

import java.util.List;
import java.util.Date;
import java.util.Map;

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
     * 根据学生ID获取请假条状态为“已提交”的请假条的信息
     */
    List<StudentAfleave> getStudentAfleaveByStudentIdAndState(String studentId);

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

    /**
     *修改请假条信息
     * @param studentAfleaveId
     * @param studentAfleaveState
     * @return
     */
    boolean modifyStudentAfleave1(int studentAfleaveId,String studentAfleaveState);
//
//    /**
//     * 删除请假条信息
//     * @param studentAfleaveId
//     * @return
//     */
//    boolean deleteStudentAfleave(String studentAfleaveId);
    /**
     * 增加学生请假条信息1
     * @return
     */
    boolean addStudentAfleave1(int studentAfleaveId, String studentId, String counsellorId, String studentAname, String studentClass, String studentNumber, Date studentAfleaveStartTime, Date studentAfleaveEndTime, int studentAfleaveDays, String studentAfleavePlace, String studentAfleaveReason, String studentAfleaveState);

}
