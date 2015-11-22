package com.qrj.banche.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Checi;
import com.qrj.banche.entity.ZhandianCheci;
import com.qrj.banche.repository.CheciMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lcssos on 15/11/21.
 */

@Component
@Scope("prototype")
public class getzhandiancheci extends ActionSupport implements ModelDriven<Object> {

    private Integer total;
    private List<ZhandianCheci> rows;
    private Integer checiId;

    public Integer getCheciId() {
        return checiId;
    }

    public void setCheciId(Integer checiId) {
        this.checiId = checiId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ZhandianCheci> getRows() {
        return rows;
    }

    public void setRows(List<ZhandianCheci> rows) {
        this.rows = rows;
    }

    @Resource
    private CheciMapper checiMapper;

    @Override
    public String execute() throws Exception {



        rows = checiMapper.selectZhandianByCheciId(checiId);

        total = rows.size();

        return Action.SUCCESS;
    }

    @Override
    public Object getModel() {
        return null;
    }
}
