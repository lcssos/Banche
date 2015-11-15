package com.qrj.banche.repository;

import com.qrj.banche.entity.Wxuser;

public interface WxuserMapper {
    int deleteByPrimaryKey(Integer wxuserId);

    int insert(Wxuser record);

    int insertSelective(Wxuser record);

    Wxuser selectByPrimaryKey(Integer wxuserId);

    int updateByPrimaryKeySelective(Wxuser record);

    int updateByPrimaryKey(Wxuser record);
}