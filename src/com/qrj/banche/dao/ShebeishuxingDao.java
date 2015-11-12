package com.qrj.banche.dao;


import com.qrj.banche.model.Shebeishuxing;

import java.util.List;

public interface ShebeishuxingDao {
    public void save(Shebeishuxing shebeishuxing);

    public void update(Shebeishuxing shebeishuxing);

    public void delete(Shebeishuxing shebeishuxing);

    public List<Shebeishuxing> findByshebeiid(long shebeiid);

    public List<Shebeishuxing> findByshebeiIdandStatus(long shebeiid, int status);
}
