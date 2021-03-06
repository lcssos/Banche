package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Shebeishuxing;
import com.qrj.banche.repository.ShebeishuxingMapper;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("changshebei")
//每一次请求都建个新的action
@Scope("prototype")
public class changshebei extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private ShebeishuxingMapper shebeishuxingMapper;

    private List<Shebeishuxing> shebeis;

    private String cuowumessage;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        int comid = (Integer) request.getSession().getAttribute("comid");
        if (comid == 0) {
            //searchshebei 1 查询 2删除 3更改状态
            switch (searchInfo.getSearchshebei()) {
                case 1:
                    shebeis = shebeishuxingMapper.findByshebeiIdandStatus(searchInfo.getSearchsheibeiid(), searchInfo.getSearchshebeizhuangtai());
                    return "success";
                case 2:
                    //暂时没有删除需要，但是暂时保留

                case 3:
                    shebeis = shebeishuxingMapper.findByshebeiid(searchInfo.getDeleteshebeiid());
                    if (shebeis.size() > 0) {
                        if (searchInfo.getUpdatestatus() == 0) {
                            shebeis.get(0).setShebeishuxingShebeistatus(1);
                        } else {
                            shebeis.get(0).setShebeishuxingShebeistatus(0);
                        }
                        shebeishuxingMapper.updateByPrimaryKeySelective(shebeis.get(0));
                    }
                    shebeis = shebeishuxingMapper.findByshebeiIdandStatus(0, 1);
                    return "success";
                default:
                    break;
            }
        }

        return "faild";
    }

    public changshebei() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }

    public List<Shebeishuxing> getShebeis() {
        return shebeis;
    }

    public void setShebeis(List<Shebeishuxing> shebeis) {
        this.shebeis = shebeis;
    }

    public String getCuowumessage() {
        return cuowumessage;
    }

    public void setCuowumessage(String cuowumessage) {
        this.cuowumessage = cuowumessage;
    }
}
