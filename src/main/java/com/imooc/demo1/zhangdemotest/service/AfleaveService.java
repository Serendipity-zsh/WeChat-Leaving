package com.imooc.demo1.zhangdemotest.service;

import com.imooc.demo1.zhangdemotest.entity.Afleave;


import java.util.List;

public interface AfleaveService {
    /**
     * 获取请假条列表
     *
     * @return Afleave
     */
    List<Afleave> getAfleaveList();

    /**
     * 根据AfleaveId获取请假条信息
     * @param afleaveId
     * @return
     */
    Afleave getAfleaveById(String afleaveId);

    /**
     * 根据学生ID获取请假条信息
     */
    Afleave getAfleaveByStudentId(String studentId);

    /**
     * 增加请假条信息
     * @param afleave
     * @return
     */
    boolean addAfleave(Afleave afleave);

    /**
     *修改请假条信息
     * @param afleave
     * @return
     */
    boolean modifyAfleave(Afleave afleave);

    /**
     * 删除请假条信息
     * @param afleaveId
     * @return
     */
    boolean deleteAfleave(String afleaveId);
}
