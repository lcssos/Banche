package com.qrj.banche.repository;

import com.qrj.banche.entity.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<Company> findBycomdetid(int comdetid);
    List<Company> findByNameAndPassword(@Param("comname") String comname, @Param("password") String compassword);
}