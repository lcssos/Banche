package com.qrj.banche.repository;

import com.qrj.banche.entity.Zhandian;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhandianMapper {
    int deleteByPrimaryKey(Integer zhandianId);

    int insert(Zhandian record);

    int insertSelective(Zhandian record);

    Zhandian selectByPrimaryKey(Integer zhandianId);

    int updateByPrimaryKeySelective(Zhandian record);

    int updateByPrimaryKey(Zhandian record);

    List<Zhandian> findByBancheId(int bancheid);
    List<Zhandian> findByZhandianId(int zhandianid);
    List<Zhandian> findByBancheIdandXuhao(@Param("bancheid") int bancheid, @Param("xuhao") int xuhao);
    List<Zhandian> findByBancheIdandyincang(@Param("bancheid") int bancheid, @Param("yincang") int yincang);

}