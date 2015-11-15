package com.qrj.banche.dao;

import com.qrj.banche.model.Wxlocation;

import java.util.List;

/**
 * Created by liujian on 15/8/13.
 */
public interface WxlocationDao {
    public void save(Wxlocation wxlocation);

    public void update(Wxlocation wxlocation);

    public void delete(Wxlocation wxlocation);

    public List<Wxlocation> findByopenId(String openId);

}
