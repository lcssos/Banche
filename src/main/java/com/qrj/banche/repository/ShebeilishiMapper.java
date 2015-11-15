package com.qrj.banche.repository;

import com.qrj.banche.entity.Shebeilishi;

import java.util.List;

public interface ShebeilishiMapper {
    int deleteByPrimaryKey(Integer shebeilishiId);

    int insert(Shebeilishi record);

    int insertSelective(Shebeilishi record);

    Shebeilishi selectByPrimaryKey(Integer shebeilishiId);

    int updateByPrimaryKeySelective(Shebeilishi record);

    int updateByPrimaryKey(Shebeilishi record);

    List<Shebeilishi> findByshebeiidthelast5(long shebeiid);
}