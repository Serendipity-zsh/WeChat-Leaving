package com.imooc.demo1.zhangdemotest.dao;

import com.imooc.demo1.zhangdemotest.entity.Afleave;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfleaveDao {
    /**
     * 列出请假条信息
     * @return AfleaveList
     */
    List<Afleave> queryAfleave();

    /**
     * 根据AfleaveId列出具体请假条信息
     * @return Afleave
     */
    Afleave queryAfleaveById(String Afleave);

    /**
     * 根据学生ID列出具体请假条信息
     */
    Afleave queryAfleaveByStudentId(String Afleave);

    /**
     * 插入请假条信息
     * @param afleave
     * @return
     */
    int insertAfleave(Afleave afleave);

    /**
     *更新请假条信息
     * @param afleave
     *
     * @return
     */
    int updateAfleave(Afleave afleave);

    /**
     * 删除请假条信息
     * @param AfleaveId
     * @return
     */
    int deleteAfleave(String AfleaveId);
}
