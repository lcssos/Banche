package com.qrj.banche.repository;

import com.qrj.banche.entity.Wxlocation;

import java.util.List;

public interface WxlocationMapper {
    int deleteByPrimaryKey(String openid);

    int insert(Wxlocation record);

    int insertSelective(Wxlocation record);

    Wxlocation selectByPrimaryKey(String openid);

    int updateByPrimaryKeySelective(Wxlocation record);

    int updateByPrimaryKey(Wxlocation record);

    List<Wxlocation> findByopenId(String openId);
}