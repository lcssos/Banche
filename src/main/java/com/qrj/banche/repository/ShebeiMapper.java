package com.qrj.banche.repository;

import com.qrj.banche.entity.Shebei;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShebeiMapper {
    int deleteByPrimaryKey(Long shebeiId);

    int insert(Shebei record);

    int insertSelective(Shebei record);

    Shebei selectByPrimaryKey(Long shebeiId);

    int updateByPrimaryKeySelective(Shebei record);

    int updateByPrimaryKey(Shebei record);

//    List<Shebei> findByshebeiId(long shebeiid);
    List<Shebei> findByshebeiids(@Param("shebeiids") long[] shebeiids);
}