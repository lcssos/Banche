package com.qrj.banche.dao;

import com.qrj.banche.model.Wxaccesstoken;

import java.util.List;

public interface WxaccesstokenDao {
    public void save(Wxaccesstoken wxaccesstoken);

    public void update(Wxaccesstoken wxaccesstoken);

    public void delete(Wxaccesstoken wxaccesstoken);

    public List<Wxaccesstoken> findByid(int id);

    public List<Wxaccesstoken> findall();
}
