package com.imooc.demo1.zhangdemotest.dao;

import com.imooc.demo1.zhangdemotest.entity.Counsellor;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounsellorDao {
    /**
     * 列出辅导员信息
     * @return AreaList
     */
    List<Counsellor> queryCounsellor();

    /**
     * 根据CounsellorId列出具体辅导员信息
     * @return Counsellor
     */
    Counsellor queryCounsellorById(String CounsellorId);

    /**
     * 根据CounsellorId列出具体辅导员姓名
     * @return CounsellorName
     */
    String queryCounsellorNameById(String CounsellorId);

    /**
     * 插入辅导员信息
     * @param counsellor
     * @return
     */
    int insertCounsellor(Counsellor counsellor);

    /**
     *更新辅导员信息
     * @param counsellor
     * @return
     */
    int updateCounsellor(Counsellor counsellor);

    /**
     * 删除管理员信息
     * @param CounsellorId
     * @return
     */
    int deleteCounsellor(String CounsellorId);

    /**
     * 根据counsellorId和counsellorName列出具体辅导员信息
     * @return Counsellor
     */
    Counsellor queryCounsellorByIdName(String counsellorId,String counsellorName);
}
