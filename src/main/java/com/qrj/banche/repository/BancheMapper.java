package com.qrj.banche.repository;

import com.qrj.banche.entity.Banche;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BancheMapper {
    int deleteByPrimaryKey(Integer bancheId);

    int insert(Banche record);

    int insertSelective(Banche record);

    Banche selectByPrimaryKey(Integer bancheId);

    int updateByPrimaryKeySelective(Banche record);

    int updateByPrimaryKey(Banche record);

    List<Banche> findByBancheId(int bancheid);
    List<Banche> findByBancheNameAndComidAndstatus(@Param("bancheName") String banche_name, @Param("comdetId") int comdet_id, @Param("status") int status);
    List<Banche> findBycomdetid(int comdetId);
    List<Banche> findByBancheNameAndstatus(@Param("bancheName") String banche_name, @Param("status") int status);
    List<Banche> findAll();
}