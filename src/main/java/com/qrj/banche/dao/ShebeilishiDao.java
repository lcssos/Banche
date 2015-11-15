package com.qrj.banche.dao;

import com.qrj.banche.model.Shebeilishi;

import java.util.List;

public interface ShebeilishiDao {
    public List<Shebeilishi> findByshebeiidthelast5(long shebeiid);

    public List<Shebeilishi> findByshebeilishishijianandshebeiid(String time, long shebeiid);

    public List<Shebeilishi> finddayushebeilishishijianandshebeiid(String time, long shebeiid);

    public List<Shebeilishi> findguiji(String startday, String starttime, String endday, String endtime, long shebeiid);

    public List<String> findhuodong(String time);
}
