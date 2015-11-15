package com.qrj.banche.repository;

import com.qrj.banche.entity.Cheliang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheliangMapper {
    int deleteByPrimaryKey(Integer cheliangId);

    int insert(Cheliang record);

    int insertSelective(Cheliang record);

    Cheliang selectByPrimaryKey(Integer cheliangId);

    int updateByPrimaryKeySelective(Cheliang record);

    int updateByPrimaryKey(Cheliang record);

    List<Cheliang> findByBancheid(int bancheid);

    List<Cheliang> findByChepaiAndshebeiId(@Param("chepai") String chepai, @Param("shebeiid") long shebeiid);
    List<Cheliang> findByChepaiAndshebeiIdandcomid(@Param("chepai") String chepai, @Param("shebeiid") long shebeiid, @Param("comdetid") int comid);
    List<Cheliang> findByChepai(String cheliang_chepai);
    List<Cheliang> findByChepaiAndcomid(@Param("chepai") String chepai, @Param("comdetid") int comid);
    List<Cheliang> findByCheliangid(int cheliangid);
    List<Cheliang> findByshebeiid(long shebeiid);
}