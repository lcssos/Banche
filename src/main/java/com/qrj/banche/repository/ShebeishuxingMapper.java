package com.qrj.banche.repository;

import com.qrj.banche.entity.Shebeishuxing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShebeishuxingMapper {
    int deleteByPrimaryKey(Integer shebeishuxingId);

    int insert(Shebeishuxing record);

    int insertSelective(Shebeishuxing record);

    Shebeishuxing selectByPrimaryKey(Integer shebeishuxingId);

    int updateByPrimaryKeySelective(Shebeishuxing record);

    int updateByPrimaryKey(Shebeishuxing record);

    List<Shebeishuxing> findByshebeiid(long shebeiid);
    List<Shebeishuxing> findByshebeiIdandStatus(@Param("shebeiid") long shebeiid, @Param("status") int status);
}