package com.qrj.banche.repository;

import com.qrj.banche.vo.Fujinzd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lcssos on 15/11/15.
 */
public interface FunctionMapper {

    List<Fujinzd> callfujinzd(@Param("juli") int juli, @Param("openId") String openId, @Param("bancheid") int bancheid);
}
