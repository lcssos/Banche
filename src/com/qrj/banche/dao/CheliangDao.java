package com.qrj.banche.dao;


import com.qrj.banche.model.Cheliang;

import java.util.List;

public interface CheliangDao {
    public void save(Cheliang cheliang);

    public void update(Cheliang cheliang);

    public void delete(Cheliang cheliang);

    public List<Cheliang> findByChepai(String cheliang_chepai);

    public List<Cheliang> findByChepaiAndcomid(String chepai, int comid);

    public List<Cheliang> findByChepaiAndshebeiIdandcomid(String chepai, long shebeiid, int comid);

    public List<Cheliang> findByChepaiAndshebeiId(String chepai, long shebeiid);

    public List<Cheliang> findByCheliangid(int cheliangid);

    public List<Cheliang> findByshebeiid(long shebeiid);

    public List<Cheliang> findByBancheid(int bancheid);
}
