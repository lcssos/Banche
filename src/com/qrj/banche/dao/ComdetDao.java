package com.qrj.banche.dao;


import com.qrj.banche.model.Comdet;

import java.util.List;

public interface ComdetDao {
    public void save(Comdet comdet);

    public void update(Comdet comdet);

    public void delete(Comdet comdet);

    public List<Comdet> findByname(String name);

    public List<Comdet> findAll();

    public List<Comdet> findBycomdetId(int comdetid);
}
