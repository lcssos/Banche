package com.qrj.banche.repository;

import com.qrj.banche.entity.Checi;
import com.qrj.banche.entity.ZhandianCheci;

import java.util.List;

/**
 * Created by lcssos on 15/11/19.
 */
public interface CheciMapper {

    Checi selectByPrimaryKey(Integer id);
    List<Checi> selectByBancheId(Integer bancheId);

    List<Checi> findAll();



    int insert(Checi checi);


    int insertZhandian(ZhandianCheci zc);
    int updateZhandian(ZhandianCheci zc);



    List<ZhandianCheci> selectZhandianByCheciId(Integer checiId);

}
