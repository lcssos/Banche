package com.qrj.banche.repository;

import com.qrj.banche.entity.Wxguanzhu;

public interface WxguanzhuMapper {
    int deleteByPrimaryKey(Integer wxguanzhuId);

    int insert(Wxguanzhu record);

    int insertSelective(Wxguanzhu record);

    Wxguanzhu selectByPrimaryKey(Integer wxguanzhuId);

    int updateByPrimaryKeySelective(Wxguanzhu record);

    int updateByPrimaryKey(Wxguanzhu record);
}