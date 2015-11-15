package com.qrj.banche.repository;

import com.qrj.banche.entity.Comdet;

import java.util.List;

public interface ComdetMapper {
    int deleteByPrimaryKey(Integer comdetId);

    int insert(Comdet record);

    int insertSelective(Comdet record);

    Comdet selectByPrimaryKey(Integer comdetId);

    int updateByPrimaryKeySelective(Comdet record);

    int updateByPrimaryKey(Comdet record);

    List<Comdet> findBycomdetId(int comdetid);
    List<Comdet> findByname(String name);
    List<Comdet> findAll();
}