package com.qrj.banche.dao;

import com.qrj.banche.model.Shebei;

import java.util.List;

public interface ShebeiDao {
    public void save(Shebei shebei);

    public void update(Shebei shebei);

    public void delete(Shebei shebei);

    public List<Shebei> findByshebeiIdandStatus(long shebeiid, int status);

    public List<Shebei> findByshebeiId(long shebeiid);

    public List<Shebei> fingByshebeiids(long shebeiid[]);
}
