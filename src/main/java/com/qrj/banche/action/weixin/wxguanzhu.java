package com.qrj.banche.action.weixin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Wxguanzhu;
import com.qrj.banche.repository.WxguanzhuMapper;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component("wxguanzhu")
public class wxguanzhu extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private WxguanzhuMapper wxguanzhuMapper;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        Wxguanzhu wxguanzhu = new Wxguanzhu();
        wxguanzhu.setWxguanzhuWxuserid(searchInfo.getGuanzhuwxuserid());
        wxguanzhu.setWxguanzhuBanchid(searchInfo.getGuanzhubancheid());
        wxguanzhuMapper.insert(wxguanzhu);

        return null;
    }

    public wxguanzhu() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
