package com.qrj.banche.dao;


import com.qrj.banche.model.Banche;

import java.util.List;

public interface BancheDao {
    public void save(Banche banche);

    public void update(Banche banche);

    public void delete(Banche banche);

    public List<Banche> findByBancheNameAndstatus(String banche_name, int status);

    public List<Banche> findByBancheNameAndComidAndstatus(String banche_name, int comdet_id, int status);

    public List<Banche> findByBancheId(int bancheid);

    public List<Banche> findBycomdetid(int comdetid);

    public List<Banche> findAll();
}
