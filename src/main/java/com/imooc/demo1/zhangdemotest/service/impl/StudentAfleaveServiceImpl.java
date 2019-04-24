package com.imooc.demo1.zhangdemotest.service.impl;

import com.imooc.demo1.zhangdemotest.dao.StudentAfleaveDao;
import com.imooc.demo1.zhangdemotest.entity.StudentAfleave;
import com.imooc.demo1.zhangdemotest.service.StudentAfleaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentAfleaveServiceImpl implements StudentAfleaveService {
    @Autowired
    private StudentAfleaveDao studentAfleaveDao;

    @Override
    //获取学生请假条列表
    public List<StudentAfleave> getStudentAfleaveList() {
        return studentAfleaveDao.queryStudentAfleave();
    }

    @Override
    //根据请假条ID获取请假条信息
    public StudentAfleave getStudentAfleaveById(String studentAfleaveId) {
        return studentAfleaveDao.queryStudentAfleaveById(studentAfleaveId);
    }

    @Override
    //根据学生ID获取请假条信息
    public List<StudentAfleave> getStudentAfleaveByStudentId(String studentId) {
        return studentAfleaveDao.queryStudentAfleaveByStudentId(studentId);
    }

    @Transactional
    @Override
    //添加学生请假条
    public boolean addStudentAfleave(StudentAfleave studentAfleave) {
        //判断控制,学生ID，请假时间，请假原因，地点不能为空
        int effectedNum = studentAfleaveDao.insertStudentAfleave(studentAfleave);
        if (studentAfleave.getStudentId().isEmpty()) {
            throw new RuntimeException("学生学号不能为空！");
        } else {
            if (studentAfleave.getStudentAfleavePlace().isEmpty()) {
                throw new RuntimeException("学生出行地点不能为空！");
            } else {
                if (studentAfleave.getStudentAfleaveReason().isEmpty()) {
                    throw new RuntimeException("请假原因不能为空！");
                } else {
                    if (studentAfleave.getStudentAfleaveDays() <= 0) {
                        throw new RuntimeException("请假天数错误！");
                    } else {
                        if (effectedNum > 0) {
                            return true;
                        } else {
                            throw new RuntimeException("添加请假条失败！");
                        }
                    }
                }
            }
        }
    }

    @Transactional
    @Override
    public boolean modifyStudentAfleave(StudentAfleave studentAfleave) {
        if (!studentAfleave.getStudentAfleaveState().isEmpty()) {
            try {
                int effectedNum = studentAfleaveDao.updateStudentAfleave(studentAfleave);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新学生请假条状态失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新学生请假条状态失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("学生请假条状态不能为空！");
        }
    }

}

