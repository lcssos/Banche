package com.qrj.banche.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Checi;
import com.qrj.banche.repository.CheciMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lcssos on 15/11/21.
 */

@Component("getcheci")
@Scope("prototype")
public class getcheci extends ActionSupport implements ModelDriven<Object> {

    private Integer total;
    private List<Checi> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Checi> getRows() {
        return rows;
    }

    public void setRows(List<Checi> rows) {
        this.rows = rows;
    }

    @Resource
    private CheciMapper checiMapper;

    @Override
    public String execute() throws Exception {


        rows = checiMapper.findAll();

        total = rows.size();

        return Action.SUCCESS;
    }

    @Override
    public Object getModel() {
        return null;
    }
}
