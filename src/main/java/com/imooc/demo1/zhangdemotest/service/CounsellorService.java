package com.imooc.demo1.zhangdemotest.service;

import com.imooc.demo1.zhangdemotest.entity.Counsellor;


import java.util.List;

public interface CounsellorService {
    /**
     * 获取辅导员列表
     *
     * @return CounsellorList
     */
    List<Counsellor> getCounsellorList();

    /**
     * 根据CounsellorId获取辅导员信息
     * @param counsellorId
     * @return
     */
    Counsellor getCounsellorById(String counsellorId);

    /**
     * 根据CounsellorId列出具体辅导员姓名
     * @return Counsellor
     */
    String queryCounsellorNameById(String counsellorId);

    /**
     * 增加辅导员信息
     * @param counsellor
     * @return
     */
    boolean addCounsellor(Counsellor counsellor);

    /**
     *修改辅导员信息
     * @param counsellor
     * @return
     */
    boolean modifyCounsellor(Counsellor counsellor);

    /**
     * 删除辅导员信息
     * @param counsellorId
     * @return
     */
    boolean deleteCounsellor(String counsellorId);

    /**
     *认证辅导员
     */
    boolean login3(String id,String name);
}
