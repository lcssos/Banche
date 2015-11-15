package com.qrj.banche.dao;

import com.qrj.banche.model.Company;

import java.util.List;

public interface CompanyDao {
    public void save(Company company);

    public void update(Company company);

    public void delete(Company company);

    public List<Company> findByNameAndPassword(String comname, String compassword);

    public List<Company> findBycomdetid(int comdetid);
}
