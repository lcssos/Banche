package com.qrj.banche.service;

import com.qrj.banche.entity.Checi;
import com.qrj.banche.entity.Zhandian;
import com.qrj.banche.entity.ZhandianCheci;
import com.qrj.banche.repository.CheciMapper;
import com.qrj.banche.repository.ZhandianMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lcssos on 15/11/21.
 */
@Service
@Transactional
public class CheciService {
    @Resource
    private CheciMapper checiMapper;

    @Resource
    private ZhandianMapper zhandianMapper;


    public void insert(Checi checi){
        Integer id = checiMapper.insert(checi);

        List<Zhandian> zhandianList = zhandianMapper.findByBancheId(checi.getBanche().getBancheId());

        if(zhandianList == null){
            throw new RuntimeException("未找到车次对应站点!");
        }

        for(Zhandian zhandian : zhandianList){
            ZhandianCheci zc = new ZhandianCheci();
            zc.setCheciId(checi.getId());
            zc.setZhandian(zhandian);
            checiMapper.insertZhandian(zc);
        }

    }



    public void updateZhandianCheci(ZhandianCheci zc){
//        zhandianMapper.insert
        if(null == zc.getId()){
            checiMapper.insertZhandian(zc);
        }else{
            checiMapper.updateZhandian(zc);
        }
    }
}
