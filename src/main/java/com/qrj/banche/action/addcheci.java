package com.qrj.banche.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Checi;
import com.qrj.banche.entity.Zhandian;
import com.qrj.banche.entity.ZhandianCheci;
import com.qrj.banche.repository.CheciMapper;
import com.qrj.banche.repository.ZhandianMapper;
import com.qrj.banche.service.CheciService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lcssos on 15/11/21.
 */
@Component("addcheci")
@Scope("prototype")
public class addcheci extends ActionSupport {

    private Checi checi;
    private Map<String,Object> map;

    public Checi getCheci() {
        return checi;
    }

    public void setCheci(Checi checi) {
        this.checi = checi;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Resource
    private CheciService checiService;

    @Override
    public String execute() throws Exception {

        checiService.insert(checi);

        map = new HashMap<>();

        map.put("status",200);
        map.put("message","创建车次成功!");

        return Action.SUCCESS;
    }

//    @Override
//    public Checi getModel() {
//        return checi;
//    }
}
