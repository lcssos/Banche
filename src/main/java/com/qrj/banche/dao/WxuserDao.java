package com.qrj.banche.dao;

import com.qrj.banche.model.Wxuser;

public interface WxuserDao {
    public void save(Wxuser wxuser);

    public void update(Wxuser wxuser);

    public void delete(Wxuser wxuser);
}
