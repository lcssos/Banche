package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Banche;
import com.qrj.banche.entity.Cheliang;
import com.qrj.banche.entity.Shebeishuxing;
import com.qrj.banche.repository.BancheMapper;
import com.qrj.banche.repository.CheliangMapper;
import com.qrj.banche.repository.ShebeishuxingMapper;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("addcheliang")
public class addcheliang extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private CheliangMapper cheliangMapper;

    @Resource
    private ShebeishuxingMapper shebeishuxingMapper;

    @Resource
    private BancheMapper bancheMapper;

    private String cuowumessage;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        int comid = (Integer) request.getSession().getAttribute("comid");
        System.out.println(searchInfo.getAddclshebeiid());
        //设备ID或者班车ID为0表示该车辆为临时添加或暂时无线路
        if (searchInfo.getAddclshebeiid() == 0 || searchInfo.getAddclbancheid() == 0) {

        } else {
            List<Shebeishuxing> shebeis = shebeishuxingMapper.findByshebeiid(searchInfo.getAddclshebeiid());
            List<Banche> banches = bancheMapper.findByBancheId(searchInfo.getAddclbancheid());
            if (shebeis.size() == 0) {
                cuowumessage = "没有该设备ID，请重新添加";
                return "faild";
            }
            if (banches.size() == 0) {
                cuowumessage = "没有该条班车线路，请重新添加";
                return "faild";
            }
        }
        Cheliang cheliang = new Cheliang();
        cheliang.setCheliangChepai(searchInfo.getAddchepai());
        cheliang.setCheliangChexing(searchInfo.getAddchexing());
        cheliang.setCheliangCheling(searchInfo.getAddcheling());
        cheliang.setCheliangZuoweishu(searchInfo.getAddzuoweishu());
        cheliang.setCheliangJiashiyuan(searchInfo.getAddjiashiyuan());
        cheliang.setCheliangTele(searchInfo.getAddtele());
        cheliang.setCheliangImage(searchInfo.getAddcheliangzhaopian());
        cheliang.setShebeiId(searchInfo.getAddclshebeiid());
        cheliang.setBancheId(searchInfo.getAddclbancheid());
        cheliang.setComdetId(comid);
        cheliangMapper.insert(cheliang);
        return "success";
    }

    public addcheliang() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }

    public String getCuowumessage() {
        return cuowumessage;
    }

    public void setCuowumessage(String cuowumessage) {
        this.cuowumessage = cuowumessage;
    }
}
