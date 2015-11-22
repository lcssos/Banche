package com.qrj.banche.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.qrj.banche.entity.Checi;
import com.qrj.banche.entity.ZhandianCheci;
import com.qrj.banche.service.CheciService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lcssos on 15/11/21.
 */
@Component
@Scope("prototype")
public class addzhandiancheci extends ActionSupport {

    private ZhandianCheci zhandianCheci;
    private Map<String,Object> map;


    public ZhandianCheci getZhandianCheci() {
        return zhandianCheci;
    }

    public void setZhandianCheci(ZhandianCheci zhandianCheci) {
        this.zhandianCheci = zhandianCheci;
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

//        checiService.insert(checi);
        checiService.updateZhandianCheci(zhandianCheci);

        map = new HashMap<>();

        map.put("status",200);
        map.put("message","创建站点车次成功!");

        return Action.SUCCESS;
    }

//    @Override
//    public Checi getModel() {
//        return checi;
//    }
}
