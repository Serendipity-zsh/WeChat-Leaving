package com.imooc.demo1.zhangdemotest.service.impl;

import com.imooc.demo1.zhangdemotest.dao.StudentAfleaveDao;
import com.imooc.demo1.zhangdemotest.entity.StudentAfleave;
import com.imooc.demo1.zhangdemotest.service.StudentAfleaveService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    //根据学生ID获取请假条状态为“已提交”的请假条的信息
    public List<StudentAfleave> getStudentAfleaveByStudentIdAndState(String studentId) {
        return studentAfleaveDao.queryStudentAfleaveByStudentIdAndState(studentId);
    }

    @Transactional
    @Override
    //添加学生请假条-对象
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
    //更新学生请假表
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

    @Transactional
    @Override
    //更新学生请假表
    public boolean modifyStudentAfleave1(int studentAfleaveId,String studentAfleaveState) {
        StudentAfleave studentAfleave=new StudentAfleave();
        studentAfleave.setStudentAfleaveId(studentAfleaveId);
        studentAfleave.setStudentAfleaveState(studentAfleaveState);

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


    @Transactional
    @Override
    //添加学生请假表-属性
    public boolean addStudentAfleave1(int studentAfleaveId, String studentId, String counsellorId, String studentAname, String studentClass, String studentNumber, Date studentAfleaveStartTime, Date studentAfleaveEndTime, int studentAfleaveDays, String studentAfleavePlace, String studentAfleaveReason, String studentAfleaveState)
    {
        //判断控制,学生ID，请假时间，请假原因，地点不能为空
        StudentAfleave studentAfleave1 = new StudentAfleave();
        studentAfleave1.setStudentAfleaveId(studentAfleaveId);
        studentAfleave1.setStudentId(studentId);
        studentAfleave1.setCounsellorId("2015090");
        studentAfleave1.setStudentAname(studentAname);
        studentAfleave1.setStudentClass(studentClass);
        studentAfleave1.setStudentNumber(studentNumber);
        studentAfleave1.setStudentAfleaveStartTime(studentAfleaveStartTime);
        studentAfleave1.setStudentAfleaveEndTime(studentAfleaveEndTime);
        studentAfleave1.setStudentAfleaveDays(studentAfleaveDays);
        studentAfleave1.setStudentAfleavePlace(studentAfleavePlace);
        studentAfleave1.setStudentAfleaveReason(studentAfleaveReason);
        studentAfleave1.setStudentAfleaveState("已提交");

        int effectedNum = studentAfleaveDao.insertStudentAfleave(studentAfleave1);
        if (studentAfleave1.getStudentId().isEmpty()) {
            throw new RuntimeException("学生学号不能为空！");
        } else {
            if (studentAfleave1.getStudentAfleavePlace().isEmpty()) {
                throw new RuntimeException("学生出行地点不能为空！");
            } else {
                if (studentAfleave1.getStudentAfleaveReason().isEmpty()) {
                    throw new RuntimeException("请假原因不能为空！");
                } else {
                    if (studentAfleave1.getStudentAfleaveDays() <= 0) {
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

}

