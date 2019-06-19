package com.imooc.demo1.zhangdemotest.dao;

import com.imooc.demo1.zhangdemotest.entity.StudentAfleave;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentAfleaveDao {
    /**
     * 列出请假条信息
     * @return AfleaveList
     */
    List<StudentAfleave> queryStudentAfleave();

    /**
     * 根据StudentAfleaveId列出具体请假条信息
     * @return Afleave
     */
    StudentAfleave queryStudentAfleaveById(String StudentAfleave);

    /**
     * 根据学生ID列出具体请假条信息
     */
    List<StudentAfleave> queryStudentAfleaveByStudentId(String studentId);

    /**
     * 根据学生ID列出具体请假条状态为“已提交”请假条信息
     */
    List<StudentAfleave> queryStudentAfleaveByStudentIdAndState(String studentId);

    /**
     * 插入学生请假条信息
     * @param studentAfleave
     * @return
     */
    int insertStudentAfleave(StudentAfleave studentAfleave);

    /**
     *更新学生请假条信息
     * @param studentAfleave
     *
     * @return
     */
    int updateStudentAfleave(StudentAfleave studentAfleave);

    /**
     * 删除学生请假条信息
     * @param StudentAfleaveId
     * @return
     */
    int deleteStudentAfleave(String StudentAfleaveId);
}
