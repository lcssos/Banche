package com.qrj.banche.repository;

import com.qrj.banche.entity.Shebeilishi;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShebeilishiMapper {
    int deleteByPrimaryKey(Integer shebeilishiId);

    int insert(Shebeilishi record);

    int insertSelective(Shebeilishi record);

    Shebeilishi selectByPrimaryKey(Integer shebeilishiId);

    int updateByPrimaryKeySelective(Shebeilishi record);

    int updateByPrimaryKey(Shebeilishi record);

    List<Shebeilishi> findByshebeiidthelast5(long shebeiid);
    List<Shebeilishi> findguiji(@Param("startday") String startday,
                                @Param("starttime") String starttime,
                                @Param("endday") String endday,
                                @Param("endtime") String endtime,
                                @Param("shebeiid") long shebeiid);
    List<String> findhuodong(String time);
    List<Shebeilishi> findByshebeilishishijianandshebeiid(@Param("time") String time, @Param("shebeiid") long shebeiid);
    List<Shebeilishi> finddayushebeilishishijianandshebeiid(@Param("time") String time,@Param("shebeiid") long shebeiid);
}