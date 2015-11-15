package com.qrj.banche.repository;

import com.qrj.banche.entity.Wxaccesstoken;

import java.util.List;

public interface WxaccesstokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wxaccesstoken record);

    int insertSelective(Wxaccesstoken record);

    Wxaccesstoken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wxaccesstoken record);

    int updateByPrimaryKey(Wxaccesstoken record);

    List<Wxaccesstoken> findByid(int id);
    List<Wxaccesstoken> findall();
}